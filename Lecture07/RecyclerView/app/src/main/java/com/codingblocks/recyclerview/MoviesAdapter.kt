package com.codingblocks.recyclerview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_movies.view.actorName
import kotlinx.android.synthetic.main.item_movies.view.image
import kotlinx.android.synthetic.main.item_movies.view.movieName

class MoviesAdapter(val moviesList: ArrayList<Movies>,val context: Context) : RecyclerView.Adapter<MoviesViewHolder>() {
    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {

        val movie = moviesList[position]
        holder.itemView.apply {
            movieName.text = movie.movieName
            actorName.text = movie.actorName
            image.setImageResource(movie.imageName)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        val inflator = LayoutInflater.from(context)
        val view = inflator.inflate(R.layout.item_movies,parent,false)
        return MoviesViewHolder(view)
    }

    override fun getItemCount(): Int = moviesList.size
}


class MoviesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)