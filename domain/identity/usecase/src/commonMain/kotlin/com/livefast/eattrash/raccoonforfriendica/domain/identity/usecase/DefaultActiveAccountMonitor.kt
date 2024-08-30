package com.livefast.eattrash.raccoonforfriendica.domain.identity.usecase

import com.livefast.eattrash.raccoonforfriendica.domain.identity.data.SettingsModel
import com.livefast.eattrash.raccoonforfriendica.domain.identity.repository.AccountCredentialsCache
import com.livefast.eattrash.raccoonforfriendica.domain.identity.repository.AccountRepository
import com.livefast.eattrash.raccoonforfriendica.domain.identity.repository.ApiConfigurationRepository
import com.livefast.eattrash.raccoonforfriendica.domain.identity.repository.IdentityRepository
import com.livefast.eattrash.raccoonforfriendica.domain.identity.repository.SettingsRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

internal class DefaultActiveAccountMonitor(
    private val accountRepository: AccountRepository,
    private val apiConfigurationRepository: ApiConfigurationRepository,
    private val identityRepository: IdentityRepository,
    private val accountCredentialsCache: AccountCredentialsCache,
    private val settingsRepository: SettingsRepository,
    coroutineDispatcher: CoroutineDispatcher = Dispatchers.IO,
) : ActiveAccountMonitor {
    private val scope = CoroutineScope(SupervisorJob() + coroutineDispatcher)

    override fun start() {
        scope.launch {
            accountRepository
                .getActiveAsFlow()
                .distinctUntilChanged()
                .onEach { account ->
                    if (account == null) {
                        apiConfigurationRepository.setAuth(null)
                        identityRepository.refreshCurrentUser(null)
                    } else {
                        val node =
                            account.handle
                                .substringAfter("@")
                                .takeIf { it.isNotEmpty() } ?: apiConfigurationRepository.defaultNode
                        apiConfigurationRepository.changeNode(node)
                        val credentials = accountCredentialsCache.get(account.id)
                        apiConfigurationRepository.setAuth(credentials)

                        identityRepository.refreshCurrentUser(account.remoteId)

                        val defaultSettings = settingsRepository.get(account.id) ?: SettingsModel()
                        settingsRepository.changeCurrent(defaultSettings)
                    }
                }.launchIn(this)
        }
    }
}