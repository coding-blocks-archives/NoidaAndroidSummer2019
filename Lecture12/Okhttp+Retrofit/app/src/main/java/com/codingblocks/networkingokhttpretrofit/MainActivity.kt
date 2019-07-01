package com.codingblocks.networkingokhttpretrofit

import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.codingblocks.networkingokhttpretrofit.Client.retrofitCallBack
import com.codingblocks.networkingokhttpretrofit.Client.service
import kotlinx.android.synthetic.main.activity_main.textView

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
        val inflater = LayoutInflater.from(this)

        AlertDialog.Builder(this).setTitle("Hello").setMessage("Hello Everyone")
            .setPositiveButton("Ok") { dialogInterface: DialogInterface, i: Int ->
                service.listUsers().enqueue(retrofitCallBack { response, throwable ->
                    response?.let {
                        runOnUiThread {
                            textView.text = it.body()?.items.toString()
                        }
                    }

                })
//                service.listUsers().enqueue(object : Callback<GIthubResponse> {
//                    override fun onFailure(call: Call<GIthubResponse>, t: Throwable) {
//                    }
//
//                    override fun onResponse(
//                        call: Call<GIthubResponse>,
//                        response: Response<GIthubResponse>
//                    ) {
//
//                        runOnUiThread {
//                            textView.text = response.body()?.items.toString()
//                        }
//
//                    }
//
//                })
            }
            .setNegativeButton("Cancel") { dialogInterface: DialogInterface, i: Int ->
                dialogInterface.dismiss()
            }.setCancelable(true)
            .show()


    }


}