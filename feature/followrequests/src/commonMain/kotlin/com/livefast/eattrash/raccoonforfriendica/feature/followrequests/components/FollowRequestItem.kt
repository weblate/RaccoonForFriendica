package com.livefast.eattrash.raccoonforfriendica.feature.followrequests.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.FilterQuality
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.livefast.eattrash.raccoonforfriendica.core.appearance.theme.IconSize
import com.livefast.eattrash.raccoonforfriendica.core.appearance.theme.Spacing
import com.livefast.eattrash.raccoonforfriendica.core.appearance.theme.ancillaryTextAlpha
import com.livefast.eattrash.raccoonforfriendica.core.commonui.components.CustomImage
import com.livefast.eattrash.raccoonforfriendica.core.commonui.components.PlaceholderImage
import com.livefast.eattrash.raccoonforfriendica.core.l10n.messages.LocalStrings
import com.livefast.eattrash.raccoonforfriendica.domain.content.data.UserModel

@Composable
fun FollowRequestItem(
    user: UserModel,
    modifier: Modifier = Modifier,
    onAccept: (() -> Unit)? = null,
    onReject: (() -> Unit)? = null,
    onClick: (() -> Unit)? = null,
) {
    val avatar = user.avatar.orEmpty()
    val avatarSize = IconSize.l
    val fullColor = MaterialTheme.colorScheme.onBackground
    val ancillaryColor = MaterialTheme.colorScheme.onBackground.copy(ancillaryTextAlpha)
    val acceptColor = Color.Green
    val rejectColor = Color.Red
    val pending = user.relationshipStatusPending

    Column(
        modifier =
            modifier
                .clickable(
                    interactionSource = remember { MutableInteractionSource() },
                    indication = null,
                ) {
                    onClick?.invoke()
                }.padding(Spacing.s),
        verticalArrangement = Arrangement.spacedBy(Spacing.s),
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(Spacing.s),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            if (avatar.isNotEmpty()) {
                CustomImage(
                    modifier = Modifier.size(avatarSize).clip(RoundedCornerShape(avatarSize / 2)),
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

            Column(
                modifier = Modifier.weight(1f),
            ) {
                Text(
                    text = user.displayName ?: user.username ?: "",
                    style = MaterialTheme.typography.titleMedium,
                    color = fullColor,
                )
                Text(
                    text = user.handle ?: user.username ?: "",
                    style = MaterialTheme.typography.titleMedium,
                    color = ancillaryColor,
                )
            }
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(Spacing.s),
        ) {
            OutlinedButton(
                modifier = Modifier.weight(1f),
                border = BorderStroke(1.dp, rejectColor),
                onClick = {
                    onReject?.invoke()
                },
            ) {
                if (pending) {
                    CircularProgressIndicator(
                        modifier = Modifier.size(IconSize.s),
                        color = MaterialTheme.colorScheme.onPrimary,
                    )
                }
                Text(
                    text = LocalStrings.current.actionReject,
                    color = rejectColor,
                )
            }
            OutlinedButton(
                modifier = Modifier.weight(1f),
                border = BorderStroke(1.dp, acceptColor),
                onClick = {
                    onAccept?.invoke()
                },
            ) {
                if (pending) {
                    CircularProgressIndicator(
                        modifier = Modifier.size(IconSize.s),
                        color = MaterialTheme.colorScheme.onPrimary,
                    )
                }
                Text(
                    text = LocalStrings.current.actionAccept,
                    color = acceptColor,
                )
            }
        }
    }
}