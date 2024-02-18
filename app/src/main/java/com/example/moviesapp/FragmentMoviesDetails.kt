package com.example.moviesapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels

class FragmentMoviesDetails : Fragment() {

    private val viewModel by viewModels<MoviesDetailsViewModel>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movies_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val nameText = view.findViewById<TextView>(R.id.name)
        val storylineText = view.findViewById<TextView>(R.id.storyline_text)
        val cast = view.findViewById<TextView>(R.id.cast_value)


        viewModel.currentMovie.observe(viewLifecycleOwner) { movie ->
            movie ?: return@observe
            nameText.text = movie.title
            storylineText.text = movie.storyLine
            cast.text = movie.cast
        }
    }
}