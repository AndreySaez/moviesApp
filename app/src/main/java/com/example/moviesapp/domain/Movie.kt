package com.example.moviesapp.domain

import android.os.Parcelable
import com.example.moviesapp.data.apis.GenreDto
import com.example.moviesapp.data.apis.PersonDto
import com.example.moviesapp.data.apis.PosterDto
import kotlinx.parcelize.Parcelize

@Parcelize
data class Movie(
    val reviews: Int,
    val name: String?,
    val like: Int,
    val genres: List<GenreDto>?,
    val ageRating: Int,
    val movieLength: Int?,
    val description: String?,
    val poster: PosterDto?,
    val persons:List<PersonDto>
) : Parcelable
