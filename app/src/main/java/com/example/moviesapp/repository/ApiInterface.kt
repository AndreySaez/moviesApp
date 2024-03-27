package com.example.moviesapp.repository

import com.example.moviesapp.data.MovieResponse
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ApiInterface {

    @GET("movie")
    @Headers("X-API-KEY: 4Y1K8K4-KWGMA79-P4Y7337-0GGC8CP")
    suspend fun getMovies(
        @Query("page") page: Int = 1,
        @Query("limit") limit: Int = 20,
        @Query("selectFields") fields: List<String> = listOf(
            "name",
            "description",
            "shortDescription",
            "ageRating",
            "movieLength",
            "genres",
            "poster"
        ),
    ): MovieResponse


    companion object {
        private const val BASE_URL = " https://api.kinopoisk.dev/v1.4/"
        fun create(): ApiInterface {
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
            return retrofit.create(ApiInterface::class.java)

        }
    }
}