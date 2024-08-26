package com.livefast.eattrash.raccoonforfriendica.feature.circles.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BasicAlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.FilterQuality
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.livefast.eattrash.raccoonforfriendica.core.appearance.theme.CornerSize
import com.livefast.eattrash.raccoonforfriendica.core.appearance.theme.IconSize
import com.livefast.eattrash.raccoonforfriendica.core.appearance.theme.Spacing
import com.livefast.eattrash.raccoonforfriendica.core.commonui.components.CustomImage
import com.livefast.eattrash.raccoonforfriendica.core.commonui.components.PlaceholderImage
import com.livefast.eattrash.raccoonforfriendica.core.commonui.components.SearchField
import com.livefast.eattrash.raccoonforfriendica.core.l10n.messages.LocalStrings
import com.livefast.eattrash.raccoonforfriendica.domain.content.data.UserModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun CircleAddUserDialog(
    query: String = "",
    users: List<UserModel> = emptyList(),
    onSearchChanged: ((String) -> Unit)? = null,
    onClose: ((List<UserModel>?) -> Unit)? = null,
) {
    val selectedUsers = remember { mutableStateListOf<UserModel>() }
    BasicAlertDialog(
        modifier = Modifier.clip(RoundedCornerShape(CornerSize.xxl)),
        onDismissRequest = {
            onClose?.invoke(null)
        },
    ) {
        Column(
            modifier =
                Modifier
                    .background(color = MaterialTheme.colorScheme.surfaceColorAtElevation(5.dp))
                    .padding(Spacing.m),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(Spacing.xxs),
        ) {
            Text(
                text = LocalStrings.current.circleAddUsersDialogTitle,
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onBackground,
            )
            Spacer(modifier = Modifier.height(Spacing.s))
            SearchField(
                backgroundColor = MaterialTheme.colorScheme.surfaceColorAtElevation(20.dp),
                hint = LocalStrings.current.selectUserSearchPlaceholder,
                value = query,
                onValueChange = {
                    onSearchChanged?.invoke(it)
                },
                onClear = {
                    onSearchChanged?.invoke((""))
                },
            )
            Spacer(modifier = Modifier.height(Spacing.xs))

            LazyColumn(
                modifier = Modifier.fillMaxWidth().height(300.dp),
            ) {
                items(users) { user ->
                    val isSelected = selectedUsers.any { it.id == user.id }
                    UserResultItem(
                        user = user,
                        selected = isSelected,
                        onClick = {
                            if (isSelected) {
                                selectedUsers -= user
                            } else {
                                selectedUsers += user
                            }
                        },
                    )
                }
            }

            Spacer(modifier = Modifier.height(Spacing.xs))
            Row(
                horizontalArrangement = Arrangement.spacedBy(Spacing.s),
            ) {
                Spacer(modifier = Modifier.weight(1f))
                Button(
                    onClick = {
                        onClose?.invoke(null)
                    },
                ) {
                    Text(text = LocalStrings.current.buttonCancel)
                }
                Button(
                    onClick = {
                        onClose?.invoke(selectedUsers)
                    },
                ) {
                    Text(text = LocalStrings.current.buttonConfirm)
                }
            }
        }
    }
}

@Composable
private fun UserResultItem(
    user: UserModel,
    modifier: Modifier = Modifier,
    selected: Boolean = false,
    onClick: (() -> Unit)? = null,
) {
    val avatar = user.avatar.orEmpty()
    val avatarSize = IconSize.m
    val fullColor = MaterialTheme.colorScheme.onBackground

    Row(
        modifier =
            modifier.padding(Spacing.s),
        horizontalArrangement = Arrangement.spacedBy(Spacing.s),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        if (avatar.isNotEmpty()) {
            CustomImage(
                modifier =
                    Modifier
                        .size(avatarSize)
                        .clip(RoundedCornerShape(avatarSize / 2)),
                url = avatar,
                quality = FilterQuality.Low,
                contentScale = ContentScale.FillBounds,
            )
        } else {
            PlaceholderImage(
                size = avatarSize,
                title = user.displayName ?: user.handle ?: "?",
            )
        }

        Text(
            modifier = Modifier.weight(1f),
            text = user.displayName ?: user.username ?: "",
            style = MaterialTheme.typography.titleMedium,
            color = fullColor,
        )
        Checkbox(
            modifier = Modifier.size(IconSize.s),
            checked = selected,
            onCheckedChange = {
                onClick?.invoke()
            },
        )
    }
}