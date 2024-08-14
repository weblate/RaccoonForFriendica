package com.livefast.eattrash.raccoonforfriendica.feature.composer.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AlternateEmail
import androidx.compose.material.icons.filled.Link
import androidx.compose.material.icons.filled.PhotoLibrary
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.livefast.eattrash.raccoonforfriendica.core.appearance.theme.IconSize
import com.livefast.eattrash.raccoonforfriendica.core.appearance.theme.Spacing

@Composable
internal fun UtilsBar(
    modifier: Modifier = Modifier,
    onLinkClicked: (() -> Unit)? = null,
    onMentionClicked: (() -> Unit)? = null,
    onAttachmentClicked: (() -> Unit)? = null,
) {
    Row(
        modifier =
            modifier
                .background(MaterialTheme.colorScheme.surfaceVariant)
                .padding(
                    horizontal = Spacing.s,
                    vertical = Spacing.xs,
                ),
        horizontalArrangement = Arrangement.spacedBy(Spacing.s),
    ) {
        Icon(
            modifier =
                Modifier
                    .clickable {
                        onAttachmentClicked?.invoke()
                    }.padding(Spacing.xs)
                    .size(IconSize.m),
            imageVector = Icons.Default.PhotoLibrary,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.onSurfaceVariant,
        )
        Icon(
            modifier =
                Modifier
                    .clickable {
                        onLinkClicked?.invoke()
                    }.padding(Spacing.xs)
                    .size(IconSize.m),
            imageVector = Icons.Default.Link,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.onSurfaceVariant,
        )
        Icon(
            modifier =
                Modifier
                    .clickable {
                        onMentionClicked?.invoke()
                    }.padding(Spacing.xs)
                    .size(IconSize.m),
            imageVector = Icons.Default.AlternateEmail,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.onSurfaceVariant,
        )
    }
}