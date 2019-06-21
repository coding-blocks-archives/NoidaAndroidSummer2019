package com.codingblocks.fragments

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.dc
import kotlinx.android.synthetic.main.activity_main.marvel

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dc.setOnClickListener {

            val bundle = Bundle()
            var frag = DCFragment()
            bundle.putString("NAME", "DC")

            frag.arguments = bundle
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, frag)
                .commit()
        }
        marvel.setOnClickListener {

            val bundle = Bundle()
            val frag = DCFragment()
            bundle.putString("NAME", "MARVEL")

            frag.arguments = bundle
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, frag)
                .commit()
        }

        //        supportFragmentManager.beginTransaction()
//            .replace(R.id.container, DCFragment())
//            .commit()


    }

}
