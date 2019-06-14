package com.codingblocks.listview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.listView

class MainActivity : AppCompatActivity() {


    val movies = arrayOf("Iron Man1","Captain America","THor","Avengers","Black Panther")
    val Images = arrayOf(R.drawable.ironman,R.drawable.cap,R.drawable.thor,R.drawable.avenger,R.drawable.blackpanther)
    val yearOfRelase = arrayOf("2008","2011","2010","2012","2018")
    val actors = arrayOf("RDJ","Chris Evans","Chris Hemsworth","Tom Hiddleson","Chadwick")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,movies)
        listView.adapter = adapter
    }
}
