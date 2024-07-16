package com.example.moviesapp.data.repository

import com.example.moviesapp.domain.Movie
import com.example.moviesapp.domain.repository.MovieRepository
import com.example.moviesapp.data.apis.ApiInterface
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MoviesRepositoryImpl : MovieRepository {
    override suspend fun getMovies(): List<Movie> = withContext(Dispatchers.IO) {
        ApiInterface.create().getMovies().docs
    }
}