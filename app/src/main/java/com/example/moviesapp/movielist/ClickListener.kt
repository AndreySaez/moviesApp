package com.example.moviesapp.movielist

import com.example.moviesapp.data.Movie

fun interface ClickListener {
    fun onCLick(item: Movie)
}