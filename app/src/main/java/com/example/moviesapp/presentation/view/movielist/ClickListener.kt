package com.example.moviesapp.presentation.view.movielist

import com.example.moviesapp.domain.Movie

fun interface ClickListener {
    fun onCLick(item: Movie)
}