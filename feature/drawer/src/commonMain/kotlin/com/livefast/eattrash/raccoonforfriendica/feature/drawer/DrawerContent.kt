package com.livefast.eattrash.raccoonforfriendica.feature.drawer

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Chat
import androidx.compose.material.icons.filled.Bookmarks
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material.icons.filled.Dashboard
import androidx.compose.material.icons.filled.Drafts
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Flaky
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Tag
import androidx.compose.material.icons.filled.Workspaces
import androidx.compose.material3.BasicAlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.FilterQuality
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.koin.getScreenModel
import com.livefast.eattrash.raccoonforfriendica.core.appearance.theme.CornerSize
import com.livefast.eattrash.raccoonforfriendica.core.appearance.theme.IconSize
import com.livefast.eattrash.raccoonforfriendica.core.appearance.theme.Spacing
import com.livefast.eattrash.raccoonforfriendica.core.commonui.components.CustomImage
import com.livefast.eattrash.raccoonforfriendica.core.commonui.components.CustomModalBottomSheet
import com.livefast.eattrash.raccoonforfriendica.core.commonui.components.CustomModalBottomSheetItem
import com.livefast.eattrash.raccoonforfriendica.core.commonui.components.PlaceholderImage
import com.livefast.eattrash.raccoonforfriendica.core.commonui.components.SpinnerField
import com.livefast.eattrash.raccoonforfriendica.core.l10n.messages.LocalStrings
import com.livefast.eattrash.raccoonforfriendica.core.navigation.di.getDetailOpener
import com.livefast.eattrash.raccoonforfriendica.core.navigation.di.getDrawerCoordinator
import com.livefast.eattrash.raccoonforfriendica.core.navigation.di.getNavigationCoordinator
import com.livefast.eattrash.raccoonforfriendica.core.utils.validation.toReadableMessage
import com.livefast.eattrash.raccoonforfriendica.domain.content.data.DefaultFriendicaInstances
import com.livefast.eattrash.raccoonforfriendica.feature.drawer.components.DrawerHeader
import com.livefast.eattrash.raccoonforfriendica.feature.drawer.components.DrawerShortcut
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

class DrawerContent : Screen {
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    override fun Content() {
        val model = getScreenModel<DrawerMviModel>()
        val uiState by model.uiState.collectAsState()
        val navigationCoordinator = remember { getNavigationCoordinator() }
        val drawerCoordinator = remember { getDrawerCoordinator() }
        val detailOpener = remember { getDetailOpener() }
        val scope = rememberCoroutineScope()
        var manageAccountsDialogOpened by remember { mutableStateOf(false) }
        var changeInstanceDialogOpen by remember { mutableStateOf(false) }

        fun handleOpen(action: suspend () -> Unit) {
            scope.launch {
                navigationCoordinator.popUntilRoot()
                drawerCoordinator.toggleDrawer()
                delay(50)
                action()
            }
        }

        LaunchedEffect(model) {
            model.effects
                .onEach { event ->
                    when (event) {
                        DrawerMviModel.Effect.AnonymousChangeNodeSuccess -> {
                            changeInstanceDialogOpen = false
                            drawerCoordinator.closeDrawer()
                        }
                    }
                }.launchIn(this)
        }

        ModalDrawerSheet {
            DrawerHeader(
                user = uiState.user,
                node = uiState.node,
                canSwitchAccount = uiState.availableAccounts.size > 1,
                onOpenChangeInstance = {
                    changeInstanceDialogOpen = true
                },
                onOpenSwitchAccount = {
                    manageAccountsDialogOpened = true
                },
            )

            HorizontalDivider()

            if (uiState.user == null) {
                Text(
                    modifier = Modifier.padding(horizontal = Spacing.s, vertical = Spacing.s),
                    text = LocalStrings.current.sidebarAnonymousMessage,
                    style = MaterialTheme.typography.bodyMedium,
                )
            } else {
                DrawerShortcut(
                    title = LocalStrings.current.favoritesTitle,
                    icon = Icons.Default.Favorite,
                    onSelected = {
                        handleOpen { detailOpener.openFavorites() }
                    },
                )
                DrawerShortcut(
                    title = LocalStrings.current.bookmarksTitle,
                    icon = Icons.Default.Bookmarks,
                    onSelected = {
                        handleOpen { detailOpener.openBookmarks() }
                    },
                )
                DrawerShortcut(
                    title = LocalStrings.current.followedHashtagsTitle,
                    icon = Icons.Default.Tag,
                    onSelected = {
                        handleOpen { detailOpener.openFollowedHashtags() }
                    },
                )
                DrawerShortcut(
                    title = LocalStrings.current.followRequestsTitle,
                    icon = Icons.Default.Flaky,
                    onSelected = {
                        handleOpen { detailOpener.openFollowRequests() }
                    },
                )
                DrawerShortcut(
                    title = LocalStrings.current.manageCirclesTitle,
                    icon = Icons.Default.Workspaces,
                    onSelected = {
                        handleOpen { detailOpener.openCircles() }
                    },
                )

                if (uiState.hasDirectMessages) {
                    DrawerShortcut(
                        title = LocalStrings.current.directMessagesTitle,
                        icon = Icons.AutoMirrored.Default.Chat,
                        onSelected = {
                            handleOpen { detailOpener.openDirectMessages() }
                        },
                    )
                }
                if (uiState.hasGallery) {
                    DrawerShortcut(
                        title = LocalStrings.current.galleryTitle,
                        icon = Icons.Default.Dashboard,
                        onSelected = {
                            handleOpen { detailOpener.openGallery() }
                        },
                    )
                }
                DrawerShortcut(
                    title = LocalStrings.current.unpublishedTitle,
                    icon = Icons.Default.Drafts,
                    onSelected = {
                        handleOpen { detailOpener.openUnpublished() }
                    },
                )
                if (uiState.hasCalendar) {
                    DrawerShortcut(
                        title = LocalStrings.current.calendarTitle,
                        icon = Icons.Default.CalendarMonth,
                        onSelected = {
                            handleOpen { detailOpener.openCalendar() }
                        },
                    )
                }
            }

            DrawerShortcut(
                title = LocalStrings.current.nodeInfoTitle,
                icon = Icons.Default.Info,
                onSelected = {
                    handleOpen { detailOpener.openNodeInfo() }
                },
            )

            HorizontalDivider(
                modifier = Modifier.padding(vertical = Spacing.xs),
            )

            DrawerShortcut(
                title = LocalStrings.current.settingsTitle,
                icon = Icons.Default.Settings,
                onSelected = {
                    handleOpen { detailOpener.openSettings() }
                },
            )
        }

        if (manageAccountsDialogOpened) {
            val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)
            val items =
                uiState.availableAccounts.map { account ->
                    CustomModalBottomSheetItem(
                        label = account.displayName.orEmpty(),
                        subtitle = account.handle,
                        leadingContent = {
                            val avatar = account.avatar.orEmpty()
                            val avatarSize = IconSize.xl
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
                                    title = account.displayName ?: account.handle,
                                )
                            }
                        },
                        trailingContent = {
                            RadioButton(
                                selected = account.active,
                                onClick = {},
                            )
                        },
                    )
                }
            CustomModalBottomSheet(
                title = LocalStrings.current.actionSwitchAccount,
                sheetState = sheetState,
                items = items,
                onSelected = { index ->
                    manageAccountsDialogOpened = false
                    if (index != null) {
                        val accounts = uiState.availableAccounts
                        if (index in accounts.indices) {
                            val selectedAccount = accounts[index]
                            model.reduce(DrawerMviModel.Intent.SwitchAccount(selectedAccount))
                        }
                    }
                },
            )
        }

        if (changeInstanceDialogOpen) {
            BasicAlertDialog(
                modifier = Modifier.clip(RoundedCornerShape(CornerSize.xxl)),
                onDismissRequest = {
                    changeInstanceDialogOpen = false
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
                        text = LocalStrings.current.changeNodeDialogTitle,
                        style = MaterialTheme.typography.titleMedium,
                        color = MaterialTheme.colorScheme.onBackground,
                    )
                    Spacer(modifier = Modifier.height(Spacing.s))

                    SpinnerField(
                        modifier = Modifier.fillMaxWidth(),
                        label = {
                            Text(
                                text = LocalStrings.current.fieldNodeName,
                                style = MaterialTheme.typography.bodyMedium,
                            )
                        },
                        isError = uiState.anonymousChangeNodeNameError != null,
                        supportingText = {
                            val error = uiState.anonymousChangeNodeNameError
                            if (error != null) {
                                Text(
                                    text = error.toReadableMessage(),
                                    color = MaterialTheme.colorScheme.error,
                                )
                            }
                        },
                        values =
                            buildList {
                                for (instance in DefaultFriendicaInstances) {
                                    this += buildString {
                                        append(instance.value)
                                        append("  ")
                                        append(instance.lang)
                                    } to instance.value
                                }
                                this += LocalStrings.current.itemOther to ""
                            },
                        value = uiState.anonymousChangeNodeName,
                        keyboardOptions =
                            KeyboardOptions(
                                keyboardType = KeyboardType.Text,
                            ),
                        onValueChange = { value ->
                            model.reduce(DrawerMviModel.Intent.SetAnonymousChangeNode(value))
                        },
                    )

                    Spacer(modifier = Modifier.height(Spacing.xs))
                    Button(
                        onClick = {
                            model.reduce(DrawerMviModel.Intent.SubmitAnonymousChangeNode)
                        },
                    ) {
                        Row(
                            horizontalArrangement = Arrangement.spacedBy(Spacing.s),
                            verticalAlignment = Alignment.CenterVertically,
                        ) {
                            if (uiState.anonymousChangeNodeValidationInProgress) {
                                CircularProgressIndicator(
                                    modifier = Modifier.size(IconSize.s),
                                    color = MaterialTheme.colorScheme.onPrimary,
                                )
                            }
                            Text(text = LocalStrings.current.buttonConfirm)
                        }
                    }
                }
            }
        }
    }
}
