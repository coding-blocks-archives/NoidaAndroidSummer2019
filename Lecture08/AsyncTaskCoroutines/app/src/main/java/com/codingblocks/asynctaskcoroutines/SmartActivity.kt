package com.codingblocks.asynctaskcoroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.random.Random

class SmartActivity : AppCompatActivity() {

    val uiScope = CoroutineScope(Dispatchers.Main)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button1.setOnClickListener {
            uiScope.launch {
//                for (i in 0..10){
//                    delay(5000)
//                    tv1.text= "$i"
//                }
                delay(10000)
                tv1.text= "After 10 sec"
            }

            uiScope.launch {
                delay(5000)
                tv1.text = "After 5 sec"
            }
        }

        button2.setOnClickListener {
            tv2.text = randNumber().toString()
        }


    }

    private fun randNumber() = Random(System.currentTimeMillis()).nextInt()

}
