package com.example.moviesapp.domain

import com.example.moviesapp.R
import com.example.moviesapp.data.Movie

class MovieListDataSource {
    fun getMovieData(): List<Movie> {
        return listOf(
            Movie(
                1,
                R.drawable.avengers_list,
                R.drawable.reviews_avengers,
                "Avengers: End Game",
                R.drawable.like_white,
                "Action, Adventure, Drama",
                "13+",
                "137 MIN"
            ),
            Movie(
                2,
                R.drawable.tenet_list,
                R.drawable.reviews_tenet,
                "Tenet",
                R.drawable.like_red,
                "Action, Sci-Fi, Thriller",
                "16+",
                "97 MIN"
            ),
            Movie(
                3,
                R.drawable.black_widow_list,
                R.drawable.reviews_black_widow,
                "Black Widow",
                R.drawable.like_white,
                "Action, Adventure, Sci-Fi",
                "13+",
                "102 MIN"
            ),
            Movie(
                4,
                R.drawable.wonder_woman_list,
                R.drawable.reviews_wonder_woman,
                "Wonder Woman",
                R.drawable.like_white,
                "Action, Adventure, Fantasy",
                "13+",
                "120 MIN"
            ),
        )
    }
}