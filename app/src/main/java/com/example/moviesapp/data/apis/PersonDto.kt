package com.example.moviesapp.data.apis

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PersonDto(
    val photo: String?,
    val name: String
) : Parcelable
