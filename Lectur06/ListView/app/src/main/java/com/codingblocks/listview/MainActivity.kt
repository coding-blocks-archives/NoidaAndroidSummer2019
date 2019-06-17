package com.codingblocks.listview

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.listView
import java.util.*

class MainActivity : AppCompatActivity() {


    val movies = arrayOf("Iron Man1", "Captain America", "THor", "Avengers", "Black Panther")
    val images = arrayOf(
        R.drawable.ironman,
        R.drawable.cap,
        R.drawable.thor,
        R.drawable.avenger,
        R.drawable.blackpanther
    )
    val yearOfRelase = arrayOf("2008", "2011", "2010", "2012", "2018")
    val actors = arrayOf("RDJ", "Chris Evans", "Chris Hemsworth", "Tom Hiddleson", "Chadwick")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val list: ArrayList<Movies> = arrayListOf()
        for (i in 0..99) {
            val random = Random().nextInt(5)
            list.add(
                Movies(
                    movieName = movies[random],
                    actorName = actors[random],
                    imageName = images[random],
                    yearOfRelease = yearOfRelase[random]
                )
            )
        }

        //Android Adapter
        //        val adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,movies)

        //Custom Adapter
        Log.i("TAG", list.size.toString())
        val adapter = MoviesAdapter(list, this)
        listView.adapter = adapter
    }
}
