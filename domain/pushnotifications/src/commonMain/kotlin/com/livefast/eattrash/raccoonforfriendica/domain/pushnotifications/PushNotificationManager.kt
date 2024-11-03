package com.livefast.eattrash.raccoonforfriendica.domain.pushnotifications

import com.livefast.eattrash.raccoonforfriendica.domain.identity.data.AccountModel
import kotlinx.coroutines.flow.StateFlow

interface PushNotificationManager {
    val state: StateFlow<PushNotificationManagerState>

    suspend fun refreshState()

    suspend fun startup()

    suspend fun getAvailableDistributors(): List<String>

    suspend fun saveDistributor(distributor: String)

    suspend fun clearDistributor()

    suspend fun enable()

    suspend fun disable()

    suspend fun registerEndpoint(
        account: AccountModel,
        endpoint: String,
    )

    suspend fun unregisterEndpoint(account: AccountModel)
}
