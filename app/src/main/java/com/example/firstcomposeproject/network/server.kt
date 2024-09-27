package com.example.firstcomposeproject.network

import android.content.res.AssetManager
import android.util.Log
import retrofit2.http.GET
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Headers
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import com.google.gson.Gson
import com.google.gson.JsonArray
import com.google.gson.JsonObject
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.awaitResponse
import java.io.File
import java.util.Properties


suspend fun fetchPokemonNews(bearer_token: String): List<pokemonNotification> {

    val TweetGetClient: OkHttpClient = OkHttpClient().newBuilder().addInterceptor(TweetGetInterceptor(bearer_token)).build()
    val networkModule:NetworkModule = NetworkModule()
    val retrofit:Retrofit = networkModule.getRetrofit(TweetGetClient)
    val testEndpoint:apiEndPoints = retrofit.create(apiEndPoints::class.java)
    val pokemonController:PokemonController = PokemonController()

    val gson: Gson = Gson()
    var returnList = mutableListOf<pokemonNotification>()
    val call = try {testEndpoint.getPokemonNews()}
    catch(e: Exception) {
        println("${e.message}")
        return returnList
    }

    val responseJson: JsonArray? = call




    if (responseJson != null) {
        responseJson.forEach { tweet ->
            run {

                val jsonObject = tweet.asJsonObject

                val id = jsonObject.get("id").asString
                val text = jsonObject.get("text").asString
                val dateCreated = jsonObject.get("created_at").asString

                returnList.add(pokemonNotification(text, id, dateCreated))
            }
        }
    }

    return returnList
}







data class Tweet(val id:String, val text:String, val creationDate: String){

}



