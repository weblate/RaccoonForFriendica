package com.livefast.eattrash.raccoonforfriendica.domain.content.pagination.di

import com.livefast.eattrash.raccoonforfriendica.domain.content.pagination.DefaultExplorePaginationManager
import com.livefast.eattrash.raccoonforfriendica.domain.content.pagination.DefaultFavoritesPaginationManager
import com.livefast.eattrash.raccoonforfriendica.domain.content.pagination.DefaultFollowRequestPaginationManager
import com.livefast.eattrash.raccoonforfriendica.domain.content.pagination.DefaultFollowedHashtagsPaginationManager
import com.livefast.eattrash.raccoonforfriendica.domain.content.pagination.DefaultNotificationsPaginationManager
import com.livefast.eattrash.raccoonforfriendica.domain.content.pagination.DefaultSearchPaginationManager
import com.livefast.eattrash.raccoonforfriendica.domain.content.pagination.DefaultTimelinePaginationManager
import com.livefast.eattrash.raccoonforfriendica.domain.content.pagination.DefaultUserPaginationManager
import com.livefast.eattrash.raccoonforfriendica.domain.content.pagination.ExplorePaginationManager
import com.livefast.eattrash.raccoonforfriendica.domain.content.pagination.FavoritesPaginationManager
import com.livefast.eattrash.raccoonforfriendica.domain.content.pagination.FollowRequestPaginationManager
import com.livefast.eattrash.raccoonforfriendica.domain.content.pagination.FollowedHashtagsPaginationManager
import com.livefast.eattrash.raccoonforfriendica.domain.content.pagination.NotificationsPaginationManager
import com.livefast.eattrash.raccoonforfriendica.domain.content.pagination.SearchPaginationManager
import com.livefast.eattrash.raccoonforfriendica.domain.content.pagination.TimelinePaginationManager
import com.livefast.eattrash.raccoonforfriendica.domain.content.pagination.UserPaginationManager
import org.koin.dsl.module

val domainContentPaginationModule =
    module {
        factory<TimelinePaginationManager> {
            DefaultTimelinePaginationManager(
                timelineRepository = get(),
                timelineEntryRepository = get(),
            )
        }
        factory<NotificationsPaginationManager> {
            DefaultNotificationsPaginationManager(
                notificationRepository = get(),
                userRepository = get(),
            )
        }
        factory<ExplorePaginationManager> {
            DefaultExplorePaginationManager(
                trendingRepository = get(),
                userRepository = get(),
                notificationCenter = get(),
            )
        }
        factory<UserPaginationManager> {
            DefaultUserPaginationManager(
                userRepository = get(),
                timelineEntryRepository = get(),
                circlesRepository = get(),
                notificationCenter = get(),
            )
        }
        factory<FavoritesPaginationManager> {
            DefaultFavoritesPaginationManager(
                timelineEntryRepository = get(),
            )
        }
        factory<FollowedHashtagsPaginationManager> {
            DefaultFollowedHashtagsPaginationManager(
                tagRepository = get(),
            )
        }
        factory<SearchPaginationManager> {
            DefaultSearchPaginationManager(
                searchRepository = get(),
                notificationCenter = get(),
            )
        }
        factory<FollowRequestPaginationManager> {
            DefaultFollowRequestPaginationManager(
                userRepository = get(),
            )
        }
    }
