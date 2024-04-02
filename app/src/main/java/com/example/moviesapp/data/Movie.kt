package com.example.moviesapp.data

import android.os.Parcelable
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
