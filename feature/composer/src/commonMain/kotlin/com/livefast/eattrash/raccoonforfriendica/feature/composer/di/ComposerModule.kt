package com.livefast.eattrash.raccoonforfriendica.feature.composer.di

import com.livefast.eattrash.raccoonforfriendica.feature.composer.ComposerMviModel
import com.livefast.eattrash.raccoonforfriendica.feature.composer.ComposerViewModel
import org.koin.dsl.module

val featureComposerModule =
    module {
        factory<ComposerMviModel> { params ->
            ComposerViewModel(
                inReplyToId = params[0],
                timelineEntryRepository = get(),
                photoRepository = get(),
                accountRepository = get(),
                userRepository = get(),
                userPaginationManager = get(),
            )
        }
    }