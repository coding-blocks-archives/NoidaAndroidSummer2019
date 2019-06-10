package com.codingblocks.intents

import android.content.Intent
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
        val i = Intent(this, Main2Activity::class.java)
        i.putExtra(KEY_1, edt1.text.toString())
        startActivity(i)
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
