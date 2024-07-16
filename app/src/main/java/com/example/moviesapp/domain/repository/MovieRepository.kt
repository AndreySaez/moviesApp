package com.example.moviesapp.domain.repository

import com.example.moviesapp.domain.Movie

interface MovieRepository {
    suspend fun getMovies(): List<Movie>
}