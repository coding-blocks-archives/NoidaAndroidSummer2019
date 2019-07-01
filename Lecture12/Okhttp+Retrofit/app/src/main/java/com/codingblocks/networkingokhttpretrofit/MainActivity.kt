package com.codingblocks.networkingokhttpretrofit

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.codingblocks.networkingokhttpretrofit.Client.service
import kotlinx.android.synthetic.main.activity_main.textView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        okHttpClient.newCall(getUrl("search/users?q=%22Pulkit%20Aggarwal%22"))
//            .enqueue(okhttpCallback { response, throwable ->
//                throwable?.let {
//
//                }
//                response?.let {
//                    val gson = Gson().fromJson(it.body?.string(), Github::class.java)
//                    runOnUiThread {
//                    }
//                }
//            })
            service.listUsers().enqueue(object :Callback<GIthubResponse>{
                override fun onFailure(call: Call<GIthubResponse>, t: Throwable) {
                }

                override fun onResponse(
                    call: Call<GIthubResponse>,
                    response: Response<GIthubResponse>
                ) {

                    runOnUiThread {
                        textView.text = response.body()?.items.toString()
                    }

                }

            })


    }


}