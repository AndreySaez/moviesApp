package com.example.moviesapp.moviedetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ImageView.ScaleType
import android.widget.TextView
import androidx.fragment.app.Fragment
import coil.load
import coil.size.Scale
import coil.transform.CircleCropTransformation
import com.example.moviesapp.R
import com.example.moviesapp.data.Movie

class FragmentMoviesDetails : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_movies_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val args = this.arguments
        val movieData = args?.getParcelable("Movie") as? Movie
        movieData?.let {
            bindMovie(it, view)
        }
    }

    private fun bindMovie(movieData: Movie, view: View) {
        view.findViewById<TextView>(R.id.name).apply {
            text = movieData.name
        }
        view.findViewById<TextView>(R.id.storyline_text).apply {
            text = movieData.description
        }
        view.findViewById<TextView>(R.id.genre).apply {
            text = movieData.genres?.getOrNull(0)?.name
        }
        view.findViewById<ImageView>(R.id.movie_details_poster).load(movieData.poster?.url) {
            crossfade(750)

        }

        view.findViewById<TextView>(R.id.age).apply {
            text = movieData.ageRating.toString()
        }
    }

}