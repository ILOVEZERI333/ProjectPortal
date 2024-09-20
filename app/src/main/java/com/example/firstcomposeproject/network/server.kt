package com.example.firstcomposeproject.network

import retrofit2.http.GET



interface testApiGet {
    @GET("api/news/pokemon")
    suspend fun getPokemonNotifications(){
        getPokemonNews()
    }
}