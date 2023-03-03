package hn.single.apps.features.common

import hn.single.apps.features.retrofit_coroutines.Post
import retrofit2.Response
import retrofit2.http.GET

interface IPlaceHolderJson {

    @GET("/posts/1")
    suspend fun getPostItem(): Response<Post>

    @GET("/posts")
    suspend fun getListPostItem(): Response<List<Post>>

}