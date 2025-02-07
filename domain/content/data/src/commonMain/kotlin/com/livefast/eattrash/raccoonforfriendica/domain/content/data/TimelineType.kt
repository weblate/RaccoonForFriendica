package com.livefast.eattrash.raccoonforfriendica.domain.content.data

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Book
import androidx.compose.material.icons.filled.Cottage
import androidx.compose.material.icons.filled.Public
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import com.livefast.eattrash.raccoonforfriendica.core.l10n.messages.LocalStrings

sealed interface TimelineType {
    data object All : TimelineType

    data object Subscriptions : TimelineType

    data object Local : TimelineType

    data class Circle(
        val circle: CircleModel? = null,
    ) : TimelineType
}

@Composable
fun TimelineType.toReadableName(): String =
    when (this) {
        TimelineType.All -> LocalStrings.current.timelineAll
        TimelineType.Subscriptions -> LocalStrings.current.timelineSubscriptions
        TimelineType.Local -> LocalStrings.current.timelineLocal
        is TimelineType.Circle -> circle?.name.orEmpty()
    }

fun TimelineType.toInt(): Int =
    when (this) {
        TimelineType.All -> 1
        TimelineType.Subscriptions -> 2
        is TimelineType.Circle -> 3
        else -> 0
    }

fun Int.toTimelineType(): TimelineType =
    when (this) {
        1 -> TimelineType.All
        2 -> TimelineType.Subscriptions
        3 -> TimelineType.Circle()
        else -> TimelineType.Local
    }

@Composable
fun TimelineType.toIcon(): ImageVector =
    when (this) {
        TimelineType.All -> Icons.Default.Public
        TimelineType.Local -> Icons.Default.Cottage
        TimelineType.Subscriptions -> Icons.Default.Book
        is TimelineType.Circle -> (circle?.type ?: CircleType.Other).toIcon()
    }
