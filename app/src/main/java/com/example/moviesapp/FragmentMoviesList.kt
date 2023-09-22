package com.example.moviesapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class FragmentMoviesList : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_movies_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val movieCard = view.findViewById<View>(R.id.movie_card)
        movieCard.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .add(R.id.fragment_container,FragmentMoviesDetails())
                .addToBackStack(null)
                .commit()

        }
    }

}