package com.example.moviesapp.model.repository

import com.example.moviesapp.data.Movie
import com.example.moviesapp.model.apis.ApiInterface
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MoviesRepository {
    suspend fun getMovies(): List<Movie> = withContext(Dispatchers.IO) {
        ApiInterface.create().getMovies().docs
    }
}