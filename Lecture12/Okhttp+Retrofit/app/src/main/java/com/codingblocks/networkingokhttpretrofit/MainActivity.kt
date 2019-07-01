package com.codingblocks.networkingokhttpretrofit

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.codingblocks.networkingokhttpretrofit.Client.getUrl
import com.codingblocks.networkingokhttpretrofit.Client.okHttpClient
import com.codingblocks.networkingokhttpretrofit.Client.okhttpCallback
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.textView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        okHttpClient.newCall(getUrl("search/users?q=%22Pulkit%20Aggarwal%22"))
            .enqueue(okhttpCallback { response, throwable ->
                throwable?.let {

                }
                response?.let {
                    val gson = Gson().fromJson(it.body?.string(), Github::class.java)
                    runOnUiThread {
                        textView.text = gson.items.toString()
                    }
                }
            })
    }


}
