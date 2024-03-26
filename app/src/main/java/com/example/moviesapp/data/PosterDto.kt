package com.example.moviesapp.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PosterDto(
    val url: String?,
    val previewUrl: String?
):Parcelable