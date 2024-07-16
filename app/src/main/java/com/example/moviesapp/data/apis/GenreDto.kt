package com.example.moviesapp.data.apis

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class GenreDto(
    val name:String?
):Parcelable
