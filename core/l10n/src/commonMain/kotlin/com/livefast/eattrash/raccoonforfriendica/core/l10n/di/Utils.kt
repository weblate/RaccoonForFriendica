package com.livefast.eattrash.raccoonforfriendica.core.l10n.di

import com.livefast.eattrash.raccoonforfriendica.core.l10n.L10nManager
import com.livefast.eattrash.raccoonforfriendica.core.l10n.messages.Strings

expect fun getL10nManager(): L10nManager

internal expect fun replaceLang(lang: String)

expect fun getStrings(lang: String): Strings
