package com.livefast.eattrash.raccoonforfriendica.feature.hashtag

import cafe.adriel.voyager.core.model.screenModelScope
import com.livefast.eattrash.raccoonforfriendica.core.architecture.DefaultMviModel
import com.livefast.eattrash.raccoonforfriendica.domain.content.data.TimelineEntryModel
import com.livefast.eattrash.raccoonforfriendica.domain.content.pagination.TimelinePaginationManager
import com.livefast.eattrash.raccoonforfriendica.domain.content.pagination.TimelinePaginationSpecification
import com.livefast.eattrash.raccoonforfriendica.domain.content.repository.TagRepository
import com.livefast.eattrash.raccoonforfriendica.domain.content.repository.TimelineEntryRepository
import kotlinx.coroutines.launch

class HashtagViewModel(
    private val tag: String,
    private val paginationManager: TimelinePaginationManager,
    private val timelineEntryRepository: TimelineEntryRepository,
    private val tagRepository: TagRepository,
) : DefaultMviModel<HashtagMviModel.Intent, HashtagMviModel.State, HashtagMviModel.Effect>(
        initialState = HashtagMviModel.State(),
    ),
    HashtagMviModel {
    init {
        screenModelScope.launch {
            if (uiState.value.initial) {
                val model = tagRepository.getBy(tag)
                updateState {
                    it.copy(
                        following = model?.following == true,
                    )
                }
                refresh(initial = true)
            }
        }
    }

    override fun reduce(intent: HashtagMviModel.Intent) {
        when (intent) {
            HashtagMviModel.Intent.Refresh ->
                screenModelScope.launch {
                    refresh()
                }

            HashtagMviModel.Intent.LoadNextPage ->
                screenModelScope.launch {
                    loadNextPage()
                }

            is HashtagMviModel.Intent.ToggleReblog -> toggleReblog(intent.entryId)
            is HashtagMviModel.Intent.ToggleFavorite -> toggleFavorite(intent.entryId)
            is HashtagMviModel.Intent.ToggleBookmark -> toggleBookmark(intent.entryId)
            is HashtagMviModel.Intent.ToggleTagFollow -> toggleTagFollow(intent.newValue)
        }
    }

    private suspend fun refresh(initial: Boolean = false) {
        updateState {
            it.copy(initial = initial, refreshing = !initial)
        }
        paginationManager.reset(
            TimelinePaginationSpecification.Hashtag(tag),
        )
        loadNextPage()
    }

    private suspend fun loadNextPage() {
        if (uiState.value.loading) {
            return
        }

        updateState { it.copy(loading = true) }
        val entries = paginationManager.loadNextPage()
        updateState {
            it.copy(
                entries = entries,
                canFetchMore = paginationManager.canFetchMore,
                loading = false,
                initial = false,
                refreshing = false,
            )
        }
    }

    private suspend fun updateEntryInState(
        entryId: String,
        block: (TimelineEntryModel) -> TimelineEntryModel,
    ) {
        updateState {
            it.copy(
                entries =
                    it.entries.map { entry ->
                        if (entry.id == entryId) {
                            entry.let(block)
                        } else {
                            entry
                        }
                    },
            )
        }
    }

    private fun toggleReblog(entryId: String) {
        val entry = uiState.value.entries.firstOrNull { it.id == entryId } ?: return
        screenModelScope.launch {
            val newEntry =
                if (entry.reblogged) {
                    timelineEntryRepository.unreblog(entryId)
                } else {
                    timelineEntryRepository.reblog(entryId)
                }
            if (newEntry != null) {
                updateEntryInState(entryId) {
                    it.copy(
                        reblogged = newEntry.reblogged,
                        reblogCount = newEntry.reblogCount,
                    )
                }
            }
        }
    }

    private fun toggleFavorite(entryId: String) {
        val entry = uiState.value.entries.firstOrNull { it.id == entryId } ?: return
        screenModelScope.launch {
            val newEntry =
                if (entry.favorite) {
                    timelineEntryRepository.unfavorite(entryId)
                } else {
                    timelineEntryRepository.favorite(entryId)
                }
            if (newEntry != null) {
                updateEntryInState(entryId) {
                    it.copy(
                        favorite = newEntry.favorite,
                        favoriteCount = newEntry.favoriteCount,
                    )
                }
            }
        }
    }

    private fun toggleBookmark(entryId: String) {
        val entry = uiState.value.entries.firstOrNull { it.id == entryId } ?: return
        screenModelScope.launch {
            val newEntry =
                if (entry.bookmarked) {
                    timelineEntryRepository.unbookmark(entryId)
                } else {
                    timelineEntryRepository.bookmark(entryId)
                }
            if (newEntry != null) {
                updateEntryInState(entryId) {
                    it.copy(
                        bookmarked = newEntry.bookmarked,
                    )
                }
            }
        }
    }

    private fun toggleTagFollow(newFollowing: Boolean) {
        screenModelScope.launch {
            val newModel =
                if (newFollowing) {
                    tagRepository.follow(tag)
                } else {
                    tagRepository.unfollow(tag)
                }
            updateState {
                it.copy(following = newModel?.following == true)
            }
        }
    }
}