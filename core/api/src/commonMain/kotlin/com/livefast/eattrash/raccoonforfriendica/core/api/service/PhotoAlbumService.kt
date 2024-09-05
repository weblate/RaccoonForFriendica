package com.livefast.eattrash.raccoonforfriendica.core.api.service

import com.livefast.eattrash.raccoonforfriendica.core.api.dto.FriendicaApiResult
import com.livefast.eattrash.raccoonforfriendica.core.api.dto.FriendicaPhotoAlbum
import de.jensklingenberg.ktorfit.http.Body
import de.jensklingenberg.ktorfit.http.GET
import de.jensklingenberg.ktorfit.http.POST
import io.ktor.client.request.forms.FormDataContent

interface PhotoAlbumService {
    @GET("friendica/photoalbums")
    suspend fun getAll(): List<FriendicaPhotoAlbum>

    @POST("friendica/photoalbum/update")
    suspend fun update(
        @Body data: FormDataContent,
    ): FriendicaApiResult

    @POST("friendica/photoalbum/delete")
    suspend fun delete(
        @Body data: FormDataContent
    ): FriendicaApiResult
}
