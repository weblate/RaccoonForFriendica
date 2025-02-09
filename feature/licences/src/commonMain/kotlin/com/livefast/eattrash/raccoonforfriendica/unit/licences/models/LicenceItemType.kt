package com.livefast.eattrash.raccoonforfriendica.unit.licences.models

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Api
import androidx.compose.material.icons.filled.Palette
import androidx.compose.ui.graphics.vector.ImageVector

sealed interface LicenceItemType {
    data object Library : LicenceItemType

    data object Resource : LicenceItemType
}

internal fun LicenceItemType.toIcon(): ImageVector =
    when (this) {
        LicenceItemType.Library -> Icons.Default.Api
        LicenceItemType.Resource -> Icons.Default.Palette
    }
