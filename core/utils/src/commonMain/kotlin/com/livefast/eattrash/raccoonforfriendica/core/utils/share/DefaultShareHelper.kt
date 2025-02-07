package com.livefast.eattrash.raccoonforfriendica.core.utils.share

import org.koin.core.annotation.Single

@Single
internal expect class DefaultShareHelper : ShareHelper {
    override val supportsShareImage: Boolean

    override fun share(
        url: String,
        mimeType: String,
    )

    override fun shareImage(
        path: Any?, mimeType: String)
}
