package com.example.moviesapp.presentation.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviesapp.domain.Movie
import com.example.moviesapp.data.repository.MoviesRepositoryImpl
import kotlinx.coroutines.launch

class MoviesViewModel() : ViewModel() {
    private val movieRepository = MoviesRepositoryImpl()
    val movieList: LiveData<List<Movie>> get() = _movieList
    private val _movieList = MutableLiveData<List<Movie>>()

    init {
        viewModelScope.launch {
            _movieList.value = movieRepository.getMovies()
        }
    }
}