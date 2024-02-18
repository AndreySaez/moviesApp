package com.example.moviesapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.moviesapp.model.MovieDetails
import com.example.moviesapp.repository.MovieRepository

class MoviesDetailsViewModel: ViewModel() {

    private val movieRepository = MovieRepository()
    val currentMovie: LiveData<MovieDetails> get() = _currentMovie
    private val _currentMovie = MutableLiveData<MovieDetails>()

    init {
        movieRepository.getMovie("Avengers Endgame") {
            _currentMovie.value = it
        }
    }
}