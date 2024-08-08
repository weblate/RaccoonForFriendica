package com.livefast.eattrash.raccoonforfriendica.feature.settings

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Style
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.input.nestedscroll.nestedScroll
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.koin.getScreenModel
import com.livefast.eattrash.raccoonforfriendica.core.appearance.data.toColor
import com.livefast.eattrash.raccoonforfriendica.core.appearance.data.toReadableName
import com.livefast.eattrash.raccoonforfriendica.core.appearance.theme.Spacing
import com.livefast.eattrash.raccoonforfriendica.core.commonui.content.SettingsColorRow
import com.livefast.eattrash.raccoonforfriendica.core.commonui.content.SettingsHeader
import com.livefast.eattrash.raccoonforfriendica.core.commonui.content.SettingsRow
import com.livefast.eattrash.raccoonforfriendica.core.commonui.content.SettingsSwitchRow
import com.livefast.eattrash.raccoonforfriendica.core.l10n.messages.LocalStrings
import com.livefast.eattrash.raccoonforfriendica.core.l10n.toLanguageName
import com.livefast.eattrash.raccoonforfriendica.core.navigation.di.getNavigationCoordinator
import com.livefast.eattrash.raccoonforfriendica.feature.settings.composables.ColorThemeBottomSheet
import com.livefast.eattrash.raccoonforfriendica.feature.settings.composables.FontFamilyBottomSheet
import com.livefast.eattrash.raccoonforfriendica.feature.settings.composables.LanguageBottomSheet
import com.livefast.eattrash.raccoonforfriendica.feature.settings.composables.ThemeBottomSheet
import kotlinx.coroutines.delay

class SettingsScreen : Screen {
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    override fun Content() {
        val model = getScreenModel<SettingsMviModel>()
        val uiState by model.uiState.collectAsState()
        val topAppBarState = rememberTopAppBarState()
        val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(topAppBarState)
        val navigationCoordinator = remember { getNavigationCoordinator() }
        var languageBottomSheetOpened by remember { mutableStateOf(false) }
        var themeBottomSheetOpened by remember { mutableStateOf(false) }
        var fontFamilyBottomSheetOpened by remember { mutableStateOf(false) }
        var themeColorBottomSheetOpened by remember { mutableStateOf(false) }

        Scaffold(
            topBar = {
                TopAppBar(
                    scrollBehavior = scrollBehavior,
                    title = {
                        Text(
                            modifier = Modifier.padding(horizontal = Spacing.s),
                            text = LocalStrings.current.settingsTitle,
                            style = MaterialTheme.typography.titleMedium,
                        )
                    },
                    navigationIcon = {
                        if (navigationCoordinator.canPop.value) {
                            Image(
                                modifier =
                                    Modifier.clickable {
                                        navigationCoordinator.pop()
                                    },
                                imageVector = Icons.AutoMirrored.Default.ArrowBack,
                                contentDescription = null,
                                colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onBackground),
                            )
                        }
                    },
                )
            },
            content = { padding ->
                Box(
                    modifier =
                        Modifier
                            .padding(padding)
                            .nestedScroll(scrollBehavior.nestedScrollConnection),
                ) {
                    Column {
                        SettingsHeader(
                            title = LocalStrings.current.settingsHeaderGeneral,
                            icon = Icons.Default.Settings,
                        )
                        SettingsRow(
                            title = LocalStrings.current.settingsItemLanguage,
                            value = uiState.lang.toLanguageName().orEmpty(),
                            onTap = {
                                languageBottomSheetOpened = true
                            },
                        )
                        SettingsHeader(
                            title = LocalStrings.current.settingsHeaderLookAndFeel,
                            icon = Icons.Default.Style,
                        )
                        SettingsRow(
                            title = LocalStrings.current.settingsItemTheme,
                            value = uiState.theme.toReadableName(),
                            onTap = {
                                themeBottomSheetOpened = true
                            },
                        )
                        SettingsRow(
                            title = LocalStrings.current.settingsItemFontFamily,
                            value = uiState.fontFamily.toReadableName(),
                            onTap = {
                                fontFamilyBottomSheetOpened = true
                            },
                        )
                        SettingsColorRow(
                            title = LocalStrings.current.settingsItemThemeColor,
                            subtitle = LocalStrings.current.settingsItemThemeColorSubtitle,
                            value = uiState.themeColor ?: MaterialTheme.colorScheme.primary,
                            onTap = {
                                themeColorBottomSheetOpened = true
                            },
                        )
                        if (uiState.supportsDynamicColors) {
                            SettingsSwitchRow(
                                title = LocalStrings.current.settingsItemDynamicColors,
                                subtitle = LocalStrings.current.settingsItemDynamicColorsSubtitle,
                                value = uiState.dynamicColors,
                                onValueChanged = {
                                    model.reduce(SettingsMviModel.Intent.ChangeDynamicColors(it))
                                },
                            )
                        }

                        Spacer(modifier = Modifier.height(Spacing.xxxl))
                    }
                }
            },
        )

        if (languageBottomSheetOpened) {
            ModalBottomSheet(
                onDismissRequest = {
                    languageBottomSheetOpened = false
                },
                content = {
                    LanguageBottomSheet(
                        onSelected = { lang ->
                            languageBottomSheetOpened = false
                            model.reduce(SettingsMviModel.Intent.ChangeLanguage(lang))
                        },
                    )
                },
            )
        }

        if (themeBottomSheetOpened) {
            ModalBottomSheet(
                onDismissRequest = {
                    themeBottomSheetOpened = false
                },
                content = {
                    ThemeBottomSheet(
                        onSelected = { value ->
                            themeBottomSheetOpened = false
                            model.reduce(SettingsMviModel.Intent.ChangeTheme(value))
                        },
                    )
                },
            )
        }

        if (fontFamilyBottomSheetOpened) {
            ModalBottomSheet(
                onDismissRequest = {
                    fontFamilyBottomSheetOpened = false
                },
                content = {
                    FontFamilyBottomSheet(
                        onSelected = { value ->
                            fontFamilyBottomSheetOpened = false
                            model.reduce(SettingsMviModel.Intent.ChangeFontFamily(value))
                        },
                    )
                },
            )
        }

        if (themeColorBottomSheetOpened) {
            val state = rememberModalBottomSheetState()

            // workaround needed for bottom sheets with many values
            LaunchedEffect(themeColorBottomSheetOpened) {
                if (themeColorBottomSheetOpened) {
                    delay(50)
                    state.expand()
                }
            }
            ModalBottomSheet(
                sheetState = state,
                onDismissRequest = {
                    themeColorBottomSheetOpened = false
                },
                content = {
                    ColorThemeBottomSheet(
                        colors = uiState.availableThemeColors,
                        onSelected = { value ->
                            themeColorBottomSheetOpened = false
                            model.reduce(SettingsMviModel.Intent.ChangeThemeColor(value.toColor()))
                        },
                    )
                },
            )
        }
    }
}