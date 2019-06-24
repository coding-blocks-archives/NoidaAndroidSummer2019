package com.codingblocks.bottomnavigation

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.nav_view
import kotlinx.android.synthetic.main.activity_main.textMesaage

class MainActivity : AppCompatActivity(),
    BottomNavigationView.OnNavigationItemSelectedListener {
    override fun onNavigationItemSelected(item: MenuItem): Boolean = when (item.itemId) {
        R.id.navigation_home -> {
            textMesaage.setText(R.string.title_home)
            true
        }
        R.id.navigation_dashboard -> {
            textMesaage.setText(R.string.title_dashboard)
            true
        }
        R.id.navigation_notifications -> {
            textMesaage.setText(R.string.title_notifications)
            true
        }
        else -> false

    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        nav_view.setOnNavigationItemSelectedListener(this)
    }
}
