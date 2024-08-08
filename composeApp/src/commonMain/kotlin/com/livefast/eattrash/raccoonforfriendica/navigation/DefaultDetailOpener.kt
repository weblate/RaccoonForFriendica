package com.livefast.eattrash.raccoonforfriendica.navigation

import com.livefast.eattrash.feature.accountdetail.AccountDetailScreen
import com.livefast.eattrash.raccoonforfriendica.core.navigation.DetailOpener
import com.livefast.eattrash.raccoonforfriendica.core.navigation.NavigationCoordinator
import com.livefast.eattrash.raccoonforfriendica.feature.entrydetail.EntryDetailScreen
import com.livefast.eattrash.raccoonforfriendica.feature.login.LoginScreen
import com.livefast.eattrash.raccoonforfriendica.feature.settings.SettingsScreen

class DefaultDetailOpener(
    private val navigationCoordinator: NavigationCoordinator,
) : DetailOpener {
    override fun openAccountDetail(id: String) {
        val screen = AccountDetailScreen(id)
        navigationCoordinator.push(screen)
    }

    override fun openEntryDetail(id: String) {
        val screen = EntryDetailScreen(id)
        navigationCoordinator.push(screen)
    }

    override fun openSettings() {
        val screen = SettingsScreen()
        navigationCoordinator.push(screen)
    }

    override fun openLogin() {
        val screen = LoginScreen()
        navigationCoordinator.push(screen)
    }
}