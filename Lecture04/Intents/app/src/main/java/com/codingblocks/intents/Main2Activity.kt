package com.codingblocks.intents

import android.annotation.SuppressLint
import android.content.Context
import android.net.ConnectivityManager
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main2.nameTv

class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val name = intent.getStringExtra(KEY_1)
        nameTv.text = name
        val connectService = this.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        if (connectService.activeNetworkInfo.isConnected)
            nameTv.text = "Connected"
        else{
            nameTv.text = "Not Connected"

        }
//        fab.setOnClickListener { view ->
//            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                .setAction("Action", null).show()
//        }
    }

}
