package com.example.moviesapp.presentation.view.movielist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.moviesapp.R
import com.example.moviesapp.domain.Movie

class MovieListAdapter(
    private val clickListener: ClickListener
) : RecyclerView.Adapter<ListViewHolder>() {

    private var movieList = listOf<Movie>()

    override fun getItemViewType(position: Int): Int {
        return when (position) {
            0 -> _HEADER
            else -> 1
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        return when (viewType) {
            _HEADER -> HeaderViewHolder(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.view_holder_header, parent, false)
            )

            _MOVIE -> MovieListHolder(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.view_holder_movie, parent, false)
            )

            else -> throw IllegalArgumentException()
        }
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        when (holder) {
            is MovieListHolder -> {
                holder.bindMovieData(getItem(position))
                holder.itemView.setOnClickListener {
                    clickListener.onCLick(getItem(position))
                }
            }
            is HeaderViewHolder -> holder.itemView

        }
    }

    override fun getItemCount() = movieList.size + 1
    private fun getItem(position: Int): Movie = movieList[position - 1]

    fun bindMovie(newMovie: List<Movie>) {
        movieList = newMovie
        notifyDataSetChanged()

    }
}

abstract class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

class HeaderViewHolder(header: View) : ListViewHolder(header)

class MovieListHolder(movie: View) : ListViewHolder(movie) {
    private val image = movie.findViewById<ImageView>(R.id.movie_image)
    private val reviews = movie.findViewById<ImageView>(R.id.reviews_list)
    private val title = movie.findViewById<TextView>(R.id.title_list)
    private val like = movie.findViewById<ImageView>(R.id.like)
    private val genre = movie.findViewById<TextView>(R.id.genre)
    private val age = movie.findViewById<TextView>(R.id.age_tv)
    private val min = movie.findViewById<TextView>(R.id.min)

    fun bindMovieData(movie: Movie) {
        image.load(movie.poster?.previewUrl)
        reviews.setImageResource(movie.reviews)
        title.text = movie.name
        like.setImageResource(movie.like)
        genre.text = movie.genres?.firstOrNull()?.name
        age.text = movie.ageRating.toString()
        min.text = movie.movieLength.toString()
    }

}


private const val _HEADER = 0
private const val _MOVIE = 1