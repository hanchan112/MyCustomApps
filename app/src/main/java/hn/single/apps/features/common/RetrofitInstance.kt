package hn.single.apps.features.common

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import hn.single.apps.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitInstance {

    private fun okHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .connectTimeout(Constants.CONNECT_TIMEOUT, TimeUnit.MILLISECONDS)
            .readTimeout(Constants.READ_TIMEOUT, TimeUnit.MILLISECONDS)
            .writeTimeout(Constants.WRITE_TIMEOUT, TimeUnit.MILLISECONDS)
            .retryOnConnectionFailure(true).apply {
                if (BuildConfig.DEBUG) {
                    val bodyLog = HttpLoggingInterceptor().apply {
                        level = HttpLoggingInterceptor.Level.BODY
                    }
                    addInterceptor(bodyLog)
                }
                addInterceptor {
                    val request = it.request()
                    val builder = request.newBuilder().header("Content-Type", "application/json")
                        .method(request.method, request.body).build()
                    it.proceed(builder)
                }
            }.build()
    }

    private val mRetrofit by lazy {
        val gson: Gson = GsonBuilder().setLenient().create()
        Retrofit.Builder().baseUrl(Constants.BASE_URL).client(okHttpClient())
            .addConverterFactory(GsonConverterFactory.create(gson)).build()
    }

    val PLACE_HOLDER_JSON: IPlaceHolderJson by lazy {
        mRetrofit.create(IPlaceHolderJson::class.java)
    }
}