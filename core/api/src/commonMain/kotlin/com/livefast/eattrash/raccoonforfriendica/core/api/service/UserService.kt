package com.livefast.eattrash.raccoonforfriendica.core.api.service

import com.livefast.eattrash.raccoonforfriendica.core.api.dto.Account
import com.livefast.eattrash.raccoonforfriendica.core.api.dto.Relationship
import com.livefast.eattrash.raccoonforfriendica.core.api.dto.Status
import com.livefast.eattrash.raccoonforfriendica.core.api.dto.Suggestion
import com.livefast.eattrash.raccoonforfriendica.core.api.form.FollowUserForm
import de.jensklingenberg.ktorfit.http.Body
import de.jensklingenberg.ktorfit.http.GET
import de.jensklingenberg.ktorfit.http.Headers
import de.jensklingenberg.ktorfit.http.POST
import de.jensklingenberg.ktorfit.http.Path
import de.jensklingenberg.ktorfit.http.Query

interface UserService {
    @GET("v1/accounts/{id}")
    suspend fun getById(
        @Path("id") id: String,
    ): Account

    @GET("v1/accounts/{id}/statuses")
    suspend fun getStatuses(
        @Path("id") id: String,
        @Query("max_id") maxId: String? = null,
        @Query("min_id") minId: String? = null,
        @Query("only_media") onlyMedia: Boolean = false,
        @Query("exclude_replies") excludeReplies: Boolean = false,
        @Query("exclude_reblogs") excludeReblogs: Boolean = false,
        @Query("pinned") pinned: Boolean = false,
        @Query("limit") limit: Int = 20,
    ): List<Status>

    @GET("v1/accounts/lookup")
    suspend fun lookup(
        @Query("acct") acct: String,
    ): Account

    @GET("v1/accounts/relationships")
    suspend fun getRelationships(
        @Query("id[]") id: List<String>,
    ): List<Relationship>

    @GET("v2/suggestions")
    suspend fun getSuggestions(
        @Query("limit") limit: Int,
    ): List<Suggestion>

    @GET("v1/accounts/{id}/followers")
    suspend fun getFollowers(
        @Path("id") id: String,
        @Query("max_id") maxId: String? = null,
        @Query("min_id") minId: String? = null,
        @Query("limit") limit: Int = 20,
    ): List<Account>

    @GET("v1/accounts/{id}/following")
    suspend fun getFollowing(
        @Path("id") id: String,
        @Query("max_id") maxId: String? = null,
        @Query("min_id") minId: String? = null,
        @Query("limit") limit: Int = 20,
    ): List<Account>

    @POST("v1/accounts/{id}/follow")
    @Headers("Content-Type: application/json")
    suspend fun follow(
        @Path("id") id: String,
        @Body data: FollowUserForm,
    ): Relationship

    @POST("v1/accounts/{id}/unfollow")
    @Headers("Content-Type: application/json")
    suspend fun unfollow(
        @Path("id") id: String,
    ): Relationship

    @GET("v1/follow_requests/")
    suspend fun getFollowRequests(
        @Query("max_id") maxId: String? = null,
        @Query("limit") limit: Int = 20,
    ): List<Account>

    @POST("v1/follow_requests/{id}/authorize")
    @Headers("Content-Type: application/json")
    suspend fun acceptFollowRequest(
        @Path("id") id: String,
    ): Relationship

    @POST("v1/follow_requests/{id}/reject")
    @Headers("Content-Type: application/json")
    suspend fun rejectFollowRequest(
        @Path("id") id: String,
    ): Relationship

    @GET("v1/favourites")
    suspend fun getFavorites(
        @Query("max_id") maxId: String? = null,
        @Query("min_id") minId: String? = null,
        @Query("limit") limit: Int = 20,
    ): List<Status>

    @GET("v1/bookmarks")
    suspend fun getBookmarks(
        @Query("max_id") maxId: String? = null,
        @Query("min_id") minId: String? = null,
        @Query("limit") limit: Int = 20,
    ): List<Status>
}