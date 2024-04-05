package com.example.moviesapp.view.movielist

import com.example.moviesapp.data.Movie

fun interface ClickListener {
    fun onCLick(item: Movie)
}