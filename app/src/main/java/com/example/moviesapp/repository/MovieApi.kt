package com.example.moviesapp.repository

import com.example.moviesapp.model.Movie
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface MovieApi {
    @GET("/?apikey=7968217f")
    fun searchMovie(@Query("t") request: String): Call<ResponseBody>
}