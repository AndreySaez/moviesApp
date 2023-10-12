package com.example.moviesapp.repository

import retrofit2.Retrofit

object RetrofitProvider {

    val api: MovieApi by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://www.omdbapi.com/")
            .build()

        retrofit.create(MovieApi::class.java)
    }
}