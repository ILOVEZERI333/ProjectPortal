package com.example.firstcomposeproject.network

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.google.gson.JsonArray
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response









interface apiEndPoints{


    @GET("/2/users/96879107/tweets?max_results=7")
    suspend fun getPokemonNews(

    ): JsonArray
}



class PokemonController: ViewModel() {

    private val _pokemonNewsTweets = mutableListOf<pokemonNotification>()
    private val _pokemonNews = mutableStateOf(_pokemonNewsTweets)
    val pokemonNews = _pokemonNews



    fun updatePokemonTweets(pokemonNotification: pokemonNotification){
        _pokemonNewsTweets.add(pokemonNotification)
    }


    suspend fun getPokemonNews(){



        /*
        TODO
        val notification = getApiInformation()
        */

        /*
        _pokemonNewsTweets.add(notification)
    */
    }
}




data class pokemonNotification(val textContent: String, val id: String, val dateCreated: String)

data class user(val id: Number, val name: String, val handle: String, val profileUrl: String)