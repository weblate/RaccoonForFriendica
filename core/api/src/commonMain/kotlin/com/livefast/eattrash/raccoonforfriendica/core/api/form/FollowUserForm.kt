package com.livefast.eattrash.raccoonforfriendica.core.api.form

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class FollowUserForm(
    @SerialName("reblogs") val reblogs: Boolean = false,
    @SerialName("notify") val notify: Boolean = false,
)