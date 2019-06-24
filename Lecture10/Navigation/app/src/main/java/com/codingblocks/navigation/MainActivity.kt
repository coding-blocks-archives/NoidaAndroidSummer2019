package com.codingblocks.navigation

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.toolbar

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        supportActionBar?.title = "hello"

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        super.onCreateOptionsMenu(menu)
        val menuInflator = menuInflater
        menuInflator.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean = when (item?.itemId) {

        R.id.firstButton -> {
            startActivity(Intent(this@MainActivity,Main2Activity::class.java))
            true
        }
        R.id.secondButton -> {

            true

        }
        else -> {
            super.onOptionsItemSelected(item)
        }

    }


}
