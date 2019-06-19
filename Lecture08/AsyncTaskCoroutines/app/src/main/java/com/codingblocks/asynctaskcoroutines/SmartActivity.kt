package com.codingblocks.asynctaskcoroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*
import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder
import java.net.HttpURLConnection
import java.net.URL
import kotlin.coroutines.CoroutineContext
import kotlin.random.Random

class SmartActivity : AppCompatActivity(),CoroutineScope {

    val superVisor = SupervisorJob()
    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + superVisor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button1.setOnClickListener {
          launch(Dispatchers.Unconfined) {
//                for (i in 0..10){
//                    delay(5000)
//                    tv1.text= "$i"
//                }
                delay(10000)
                tv1.text= "After 10 sec"
            }

            launch {
                delay(5000)
                tv1.text = "After 5 sec"
            }
        }

        button2.setOnClickListener {
            launch {
                val result:Deferred<String> = getUrlAsync("https://jsonplaceholder.typicode.com/posts")

                tv1.text= "Doing work over internet"
                delay(5000)

                val result2:Deferred<String> = getUrlAsync("https://jsonplaceholder.typicode.com/")
                delay(5000)
                tv1.text = "Result 1 & 2 being prepared"

                tv2.text = "result 1 =${result.await()[0]}, result 2 ${result2.await()[0]} "
            }
        }


    }

    private fun randNumber() = Random(System.currentTimeMillis()).nextInt()

    private fun getUrlAsync(urlString: String):Deferred<String>{
        return async(Dispatchers.IO) {
            val url = URL(urlString)
            val connection = url.openConnection() as HttpURLConnection
            val isr = InputStreamReader(connection.inputStream)
            val bufferReader = BufferedReader(isr)
            val sb = StringBuilder()
            var buffer:String? = ""
            while (buffer!=null){
                sb.append(buffer)
                buffer = bufferReader.readLine()
            }

            sb.toString()
        }
    }

    private suspend fun get(urlString:String):String{
        return  withContext(Dispatchers.IO){
            val url = URL(urlString)
            val connection = url.openConnection() as HttpURLConnection
            val isr = InputStreamReader(connection.inputStream)
            val bufferReader = BufferedReader(isr)
            val sb = StringBuilder()
            var buffer:String? = ""
            while (buffer!=null){
                sb.append(buffer)
                buffer = bufferReader.readLine()
            }

            sb.toString()
        }
    }

    override fun onDestroy() {
        coroutineContext.cancelChildren()
        super.onDestroy()

    }
}
