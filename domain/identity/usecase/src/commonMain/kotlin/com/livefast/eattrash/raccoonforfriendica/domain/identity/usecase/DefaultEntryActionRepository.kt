package com.livefast.eattrash.raccoonforfriendica.domain.identity.usecase

import com.livefast.eattrash.raccoonforfriendica.domain.content.data.TimelineEntryModel
import com.livefast.eattrash.raccoonforfriendica.domain.content.repository.SupportedFeatureRepository
import com.livefast.eattrash.raccoonforfriendica.domain.identity.repository.IdentityRepository
import org.koin.core.annotation.Single

@Single
internal class DefaultEntryActionRepository(
    private val identityRepository: IdentityRepository,
    private val supportedFeatureRepository: SupportedFeatureRepository,
) : EntryActionRepository {
    private val currentUserId: String? get() = identityRepository.currentUser.value?.id
    private val isLogged: Boolean get() = currentUserId != null

    override fun canShare(entry: TimelineEntryModel): Boolean = !entry.url.isNullOrBlank()

    override fun canReply(entry: TimelineEntryModel): Boolean = isLogged

    override fun canReact(entry: TimelineEntryModel): Boolean = isLogged

    override fun canBookmark(entry: TimelineEntryModel): Boolean = isLogged

    override fun canReblog(entry: TimelineEntryModel): Boolean = entry.isFromOtherUser

    override fun canEdit(entry: TimelineEntryModel): Boolean = entry.isFromCurrentUser

    override fun canDelete(entry: TimelineEntryModel): Boolean = entry.isFromCurrentUser

    override fun canReport(entry: TimelineEntryModel): Boolean = entry.isFromOtherUser

    override fun canMute(entry: TimelineEntryModel): Boolean = entry.isFromOtherUser

    override fun canTogglePin(entry: TimelineEntryModel): Boolean = entry.isFromCurrentUser

    override fun canBlock(entry: TimelineEntryModel): Boolean = entry.isFromOtherUser

    override fun canQuote(entry: TimelineEntryModel): Boolean = supportedFeatureRepository.features.value.supportsEntryShare

    private val TimelineEntryModel.isFromCurrentUser: Boolean
        get() = isLogged && creator?.id == currentUserId

    private val TimelineEntryModel.isFromOtherUser: Boolean
        get() = isLogged && creator?.id != currentUserId
}
