package com.codingblocks.asynctaskcoroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button1.setOnClickListener {

//            waitNSec(10)
//            tv1.text = "After 10 sec wait"

            Handler().postDelayed(
              Runnable {
                  tv1.text = "After 10 sec wait"
              },10000
            )
        }

        button2.setOnClickListener {
            tv2.text = randNumber().toString()
        }
    }

    private fun randNumber() = Random(System.currentTimeMillis()).nextInt()

    private fun waitNSec(n:Int){
        val start = System.currentTimeMillis()
        while (System.currentTimeMillis()<(start+n*1000));
    }
}
