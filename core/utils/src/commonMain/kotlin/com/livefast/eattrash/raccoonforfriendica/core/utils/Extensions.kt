package com.livefast.eattrash.raccoonforfriendica.core.utils

fun String?.ellipsize(
    length: Int = 100,
    ellipsis: String = "…",
): String {
    if (isNullOrEmpty() || length == 0) {
        return ""
    }
    if (this.length < length) {
        return this
    }
    return take(length - 1) + ellipsis
}