package com.example.firstcomposeproject.network

import android.app.Application
import android.content.Context
import android.content.res.AssetManager
import android.util.Log
import androidx.compose.ui.platform.LocalContext
import com.google.android.datatransport.BuildConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.DEBUG_PROPERTY_NAME
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import okhttp3.Interceptor
import okhttp3.Response
import okhttp3.OkHttpClient
import okhttp3.Request
import java.io.File
import java.io.FileInputStream
import java.io.InputStream
import java.util.Properties
import javax.inject.Singleton






class MyApp(): Application() {

    private var myApp: MyApp?= null
    private val myContext = myApp?.applicationContext


    fun getContext(): Context? {
        return myContext
    }

    override fun onCreate() {
        myApp = this
        super.onCreate()
    }

}

class TweetGetInterceptor(val bearer_token: String): Interceptor{
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest: Request = chain.request()
        val newRequest: Request = originalRequest.newBuilder().header("Authorization", bearer_token).header("Content-Type", "application/json").build()

        return chain.proceed(newRequest)
    }
}



@InstallIn(SingletonComponent::class)
@Module
public class NetworkModule() {

    val xApiUrl: String = "https://api.x.com"

    @Provides
    fun getRetrofit(TweetGetClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
                .baseUrl(xApiUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .client(TweetGetClient)
                .build();
    }

    @Provides
    fun provideApiService(retrofit: Retrofit): apiEndPoints {
        return retrofit.create(apiEndPoints::class.java)
    }

}