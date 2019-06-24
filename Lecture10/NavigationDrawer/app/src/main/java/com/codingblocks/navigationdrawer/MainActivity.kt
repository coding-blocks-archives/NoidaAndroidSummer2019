package com.codingblocks.navigationdrawer

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import com.google.android.material.navigation.NavigationView
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.drawer_layout
import kotlinx.android.synthetic.main.content_main.headerText
import kotlinx.android.synthetic.main.content_main.main_container

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val drawerLayout: androidx.drawerlayout.widget.DrawerLayout =
            findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        val toggle = ActionBarDrawerToggle(
            this,
            drawerLayout,
            toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        navView.setNavigationItemSelectedListener(this)
    }

    override fun onBackPressed() {
        val drawerLayout: androidx.drawerlayout.widget.DrawerLayout =
            findViewById(R.id.drawer_layout)
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.nav_home -> {
                changeVisibility(showContainer = true)
                changeFragment(BlankFragment2())
            }
            R.id.nav_gallery -> {
                changeVisibility(showContainer = true)
                changeFragment(BlankFragment())
            }
            R.id.nav_slideshow -> {
                changeVisibility(showContainer = false)
                headerText.text = "Hello Navigation"

            }
            R.id.nav_tools -> {
                Toast.makeText(this@MainActivity,"Hello",Toast.LENGTH_LONG).show()
            }
            R.id.nav_share -> {
                Snackbar.make(drawer_layout,"Hello Snackbar",Snackbar.LENGTH_SHORT).show()
            }
            R.id.nav_send -> {

            }
        }
        val drawerLayout: androidx.drawerlayout.widget.DrawerLayout =
            findViewById(R.id.drawer_layout)
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

    private fun changeVisibility(showContainer: Boolean) {
        if (showContainer) {
            main_container.visibility = View.VISIBLE
            headerText.visibility = View.GONE
        } else {
            main_container.visibility = View.GONE
            headerText.visibility = View.VISIBLE
        }

    }

    private fun changeFragment(frag: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.main_container, frag)
            .commit()
    }
}
