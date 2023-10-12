package com.example.moviesapp.repository

import com.example.moviesapp.model.Movie
import okhttp3.ResponseBody
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieRepository {
    private val movieApi = RetrofitProvider.api

    fun getMovie(movieRequest: String, onSuccess: (Movie) -> Unit) {
        val callback = object : Callback<ResponseBody> {
            override fun onResponse(
                call: Call<ResponseBody>,
                response: Response<ResponseBody>
            ) {
                val responseString = response.body()?.string()
                val jsonObject = responseString?.let { JSONObject(it) }
                jsonObject ?: return

                onSuccess(
                    Movie(
                        title = jsonObject.getString("Title"),
                        storyLine = jsonObject.getString("Plot"),
                        cast = jsonObject.getString("Actors")
                    )
                )
            }

            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                // TODO
            }
        }
        movieApi.searchMovie(movieRequest).enqueue(callback)
    }
}