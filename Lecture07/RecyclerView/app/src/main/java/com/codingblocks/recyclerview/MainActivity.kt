package com.codingblocks.recyclerview

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.rootView
import kotlinx.android.synthetic.main.activity_main.rvMovies
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
        val list: ArrayList<Movies> = getNRandomMovies(200)

        rvMovies.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
//        rvMovies.layoutManager = GridLayoutManager(this,3,
//            GridLayoutManager.HORIZONTAL,false)

        Snackbar.make(rootView,"Hello",Snackbar.LENGTH_LONG).setAction("Click Me") {
            Toast.makeText(this,"Hello",Toast.LENGTH_LONG).show()
        }.show()

        rvMovies.adapter = MoviesAdapter(list, this)
    }

    private fun getNRandomMovies(range: Int): ArrayList<Movies> {

        val list: ArrayList<Movies> = arrayListOf()
        for (i in 0..range) {
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
        return list
    }
}
