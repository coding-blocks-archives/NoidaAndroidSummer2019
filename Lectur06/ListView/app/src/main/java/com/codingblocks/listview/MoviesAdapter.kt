package com.codingblocks.listview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.item_movie.view.actorName
import kotlinx.android.synthetic.main.item_movie.view.image
import kotlinx.android.synthetic.main.item_movie.view.movieName


class MoviesAdapter(val movies: ArrayList<Movies>, val context: Context) : BaseAdapter() {
    override fun getItem(position: Int): Movies {
        return movies[position]
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.item_movie, parent, false)

        val nameView = view.movieName
        val actorNameView = view.actorName
        val image = view.image

        nameView.text = movies[position].movieName + "(" + movies[position].yearOfRelease + ")"
        actorNameView.text = movies[position].actorName
        image.setImageResource(movies[position].imageName)
        view.setOnClickListener {

        }
        return view
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return movies.size
    }

}