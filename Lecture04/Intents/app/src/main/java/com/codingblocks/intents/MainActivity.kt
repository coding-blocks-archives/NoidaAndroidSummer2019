package com.codingblocks.intents

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.btn1
import kotlinx.android.synthetic.main.activity_main.btn2
import kotlinx.android.synthetic.main.activity_main.btn3
import kotlinx.android.synthetic.main.activity_main.btn4
import kotlinx.android.synthetic.main.activity_main.edt1

val KEY_1 = "NAME"

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onClick(v: View?) {

        //Intent to open Browser
        //val i = Intent(Intent.ACTION_VIEW, Uri.parse("http://www.${edt1.text.toString()}"))

        //Intent to open Phone Dialer
//        val i = Intent(Intent.ACTION_DIAL, Uri.parse("tel:${edt1.text.toString()}"))


        //Intent to open Gmail
        val i = Intent(Intent.ACTION_SEND)
        i.putExtra(Intent.EXTRA_TEXT,"Byeeee") // Body
        startActivity(Intent.createChooser(i,"Send Email"))
    }

    private var btnViews = arrayOfNulls<Button>(3)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnViews = arrayOf(btn1, btn2, btn3, btn4)

        btn1.setOnClickListener(this)
        btnViews.forEach {
            it?.setOnClickListener(this)
        }


    }
}
