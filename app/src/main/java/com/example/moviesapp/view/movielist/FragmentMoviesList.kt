package com.example.moviesapp.view.movielist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.moviesapp.R
import com.example.moviesapp.view.moviedetails.FragmentMoviesDetails
import com.example.moviesapp.model.apis.ApiInterface
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

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
        val adapter = MovieListAdapter {
            val details = FragmentMoviesDetails().apply {
                arguments = bundleOf("Movie" to it)
            }
            parentFragmentManager.beginTransaction()
                .add(R.id.fragment_container, details)
                .addToBackStack(null)
                .commit()
        }
        recycler?.adapter = adapter
        recycler?.layoutManager = GridLayoutManager(context, 2).apply {
            spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
                override fun getSpanSize(position: Int): Int {
                    return when (adapter.getItemViewType(position)) {
                        _HEADER -> 2
                        else -> 1
                    }
                }
            }
        }
        val apiInterface = ApiInterface.create()
        lifecycleScope.launch(Dispatchers.IO) {
            apiInterface.getMovies().let { response ->
                response.docs.let {
                    withContext(Dispatchers.Main) {
                        adapter.bindMovie(it)
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
        }
    }


    companion object {
        private const val _HEADER = 0
    }

}