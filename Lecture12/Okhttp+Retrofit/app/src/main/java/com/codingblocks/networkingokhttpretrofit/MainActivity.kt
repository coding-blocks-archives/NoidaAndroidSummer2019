package com.codingblocks.networkingokhttpretrofit

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.textView
import okhttp3.Call
import okhttp3.Callback
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import java.io.IOException

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val client = OkHttpClient()
        val request = Request.Builder()
            .url("https://api.github.com/search/users?q=%22Pulkit%20Aggarwal%22")
            .build()
        client.newCall(request).enqueue(object : Callback {
            override fun onResponse(call: Call, response: Response) {
                val gson = Gson().fromJson(response.body?.string(), Github::class.java)
                runOnUiThread {
                    textView.text = gson.items.toString()
                }
            }

            override fun onFailure(call: Call, e: IOException) {
            }

        })
    }


}
