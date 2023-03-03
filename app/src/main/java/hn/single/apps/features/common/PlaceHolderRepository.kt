package hn.single.apps.features.common

import hn.single.apps.features.retrofit_coroutines.Post
import retrofit2.Response

class PlaceHolderRepository {

    suspend fun getPostItem() : Response<Post>{
        return RetrofitInstance.PLACE_HOLDER_JSON.getPostItem()
    }

    suspend fun getListPostItem() : Response<List<Post>> {
        return RetrofitInstance.PLACE_HOLDER_JSON.getListPostItem()
    }
}