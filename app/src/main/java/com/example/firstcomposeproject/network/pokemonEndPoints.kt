package com.example.firstcomposeproject.network

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import retrofit2.http.GET


class pokemonController: ViewModel() {

    private val _pokemonNewsTweets = mutableListOf<pokemonNotification>()
    private val _pokemonNews = mutableStateOf(_pokemonNewsTweets)
    val pokemonNews = _pokemonNews

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

private suspend fun fetchPokemonNews(){
    
}



data class pokemonNotification(val textContent: String, val id: Number)

data class user(val id: Number, val name: String, val handle: String, val profileUrl: String)