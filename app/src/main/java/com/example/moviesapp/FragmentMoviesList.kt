package com.example.moviesapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.moviesapp.domain.MovieDataSource

class FragmentMoviesList : Fragment() {

    private var recycler: RecyclerView? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_movies_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recycler = view.findViewById(R.id.rc_view)
        recycler?.adapter = MovieListAdapter()
        recycler?.layoutManager = GridLayoutManager(context,2).apply {
            spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
                override fun getSpanSize(position: Int): Int {
                    return when (MovieListAdapter().getItemViewType(position)){
                        _HEADER -> 2
                        else -> 1
                    }
                }
            }
        }
    }

    override fun onStart() {
        super.onStart()
        updateData()
    }

    private fun updateData() {
        (recycler?.adapter as? MovieListAdapter)?.apply {
            bindActors(MovieDataSource().getMovieData())
        }
    }


    companion object {
        private const val _HEADER = 0
    }

}