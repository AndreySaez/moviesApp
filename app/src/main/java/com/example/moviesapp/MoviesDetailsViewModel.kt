package com.example.moviesapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.moviesapp.model.Movie
import com.example.moviesapp.repository.MovieRepository

class MoviesDetailsViewModel: ViewModel() {

    private val movieRepository = MovieRepository()
    val currentMovie: LiveData<Movie> get() = _currentMovie
    private val _currentMovie = MutableLiveData<Movie>()

    init {
        _currentMovie.value = movieRepository.getMovie()
    }
}