package com.github.akesiseli.raccoonforfriendica.core.appearance.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.shapes
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import com.github.akesiseli.raccoonforfriendica.core.appearance.data.UiBarTheme
import com.github.akesiseli.raccoonforfriendica.core.appearance.data.UiTheme
import com.github.akesiseli.raccoonforfriendica.core.appearance.di.getBarColorProvider
import com.github.akesiseli.raccoonforfriendica.core.appearance.di.getColorSchemeProvider
import com.github.akesiseli.raccoonforfriendica.core.appearance.di.getThemeRepository

@Composable
fun AppTheme(
    useDynamicColors: Boolean,
    barTheme: UiBarTheme = UiBarTheme.Solid,
    content: @Composable () -> Unit,
) {
    val repository =
        remember {
            getThemeRepository()
        }

    val themeState by repository.uiTheme.collectAsState()
    val customSeedColor by repository.customSeedColor.collectAsState()
    val defaultTheme =
        if (isSystemInDarkTheme()) {
            UiTheme.Dark
        } else {
            UiTheme.Light
        }

    val colorSchemeProvider = remember { getColorSchemeProvider() }
    val colorScheme =
        colorSchemeProvider.getColorScheme(
            theme = themeState ?: defaultTheme,
            dynamic = useDynamicColors,
            customSeed = customSeedColor,
        )

    val fontFamily by repository.fontFamily.collectAsState()
    val typography = fontFamily.toTypography()

    val barColorProvider = remember { getBarColorProvider() }
    barColorProvider.setBarColorAccordingToTheme(
        theme = themeState ?: defaultTheme,
        barTheme = barTheme,
    )

    MaterialTheme(
        colorScheme = colorScheme,
        typography = typography,
        shapes = shapes,
        content = content,
    )
}
