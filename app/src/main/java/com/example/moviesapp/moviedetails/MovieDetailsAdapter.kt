package com.example.moviesapp.moviedetails

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.moviesapp.R
import com.example.moviesapp.data.Actor

class MovieDetailsAdapter : RecyclerView.Adapter<ActorHolder>() {

    private var actorList = listOf<Actor>()
    private fun getItem(position: Int): Actor = actorList[position]

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActorHolder {
        return ActorHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.view_holder_actor, parent, false)
        )
    }

    override fun getItemCount() = actorList.size

    override fun onBindViewHolder(holder: ActorHolder, position: Int) {


    }
}

class ActorHolder(actor: View) : RecyclerView.ViewHolder(actor) {
    private val actorImage = actor.findViewById<ImageView>(R.id.actor_image)
    private val actorName = actor.findViewById<TextView>(R.id.actor_name)

    fun bindActorData(actor: Actor){
        actorImage?.setImageResource(actor.image)
        actorName?.text = actor.name
    }
}