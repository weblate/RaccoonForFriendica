package com.livefast.eattrash.raccoonforfriendica.domain.content.pagination

import com.livefast.eattrash.raccoonforfriendica.domain.content.data.UserModel
import com.livefast.eattrash.raccoonforfriendica.domain.content.data.toNotificationStatus
import com.livefast.eattrash.raccoonforfriendica.domain.content.data.toStatus
import com.livefast.eattrash.raccoonforfriendica.domain.content.repository.UserRepository

internal class DefaultUserPaginationManager(
    private val userRepository: UserRepository,
) : UserPaginationManager {
    private var specification: UserPaginationSpecification? = null
    private var pageCursor: String? = null
    override var canFetchMore: Boolean = true
    private val history = mutableListOf<UserModel>()

    override suspend fun reset(specification: UserPaginationSpecification) {
        this.specification = specification
        pageCursor = null
        history.clear()
    }

    override suspend fun loadNextPage(): List<UserModel> {
        val specification = this.specification ?: return emptyList()

        val results =
            when (specification) {
                is UserPaginationSpecification.Follower ->
                    userRepository
                        .getFollowers(
                            id = specification.userId,
                            pageCursor = pageCursor,
                        )

                is UserPaginationSpecification.Following ->
                    userRepository
                        .getFollowing(
                            id = specification.userId,
                            pageCursor = pageCursor,
                        )
            }.determineRelationshipStatus()
                .deduplicate()

        if (results.isNotEmpty()) {
            pageCursor = results.last().id
            canFetchMore = true
        } else {
            canFetchMore = false
        }

        history.addAll(results)

        // return a copy
        return history.map { it }
    }

    private suspend fun List<UserModel>.determineRelationshipStatus(): List<UserModel> =
        run {
            val userIds = map { user -> user.id }
            val relationships = userRepository.getRelationships(userIds)
            map { user ->
                val relationship = relationships.firstOrNull { rel -> rel.id == user.id }
                user.copy(
                    relationshipStatus = relationship?.toStatus(),
                    notificationStatus = relationship?.toNotificationStatus(),
                )
            }
        }

    private fun List<UserModel>.deduplicate(): List<UserModel> =
        filter { e1 ->
            history.none { e2 -> e1.id == e2.id }
        }
}