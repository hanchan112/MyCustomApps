package hn.single.apps.features.retrofit_coroutines

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class Post(

    @SerializedName("userId")
    val userId: Int,
    val id: Int,
    val title: String,
    val body: String,
)
