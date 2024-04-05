package com.example.moviesapp.view.moviedetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.moviesapp.R
import com.example.moviesapp.data.Movie

class FragmentMoviesDetails : Fragment() {

    private var recycler: RecyclerView? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_movies_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recycler = view.findViewById(R.id.rv_actors)
        val adapter = MovieDetailsAdapter()
        val args = this.arguments
        val movieData = args?.getParcelable("Movie") as? Movie
        recycler?.adapter = adapter
        recycler?.layoutManager = LinearLayoutManager(context,RecyclerView.HORIZONTAL,false)
        movieData?.let {
            bindData(it, view)
            adapter.setPerson(it.persons)
        }

    }



    private fun bindData(movieData: Movie, view: View) {
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