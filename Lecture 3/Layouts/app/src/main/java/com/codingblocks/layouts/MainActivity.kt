package com.codingblocks.layouts

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ImageView
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.activity_main.textView

class MainActivity : AppCompatActivity() {
    lateinit var ll: LinearLayout
    //imageView[]
    var imageView = arrayOf<ImageView>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        val student = Student("Pulkit", 1, true)
        //Student st = new Student("PUlkit",1,true)
        //st.getName
        //st.setame("Pulkit")
        student.name = "Pulkit"
        textView.text
        //TextView tv = findViewById(R.id.textView)


        ll = LinearLayout(this)
        //using for each loop
        imageView.forEach {
            it.apply {
                setImageResource(R.drawable.screenshot_1559550801)
                layoutParams = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                ll.addView(it)
            }
        }

        //using normal loop
        for (i in 0..2)
            imageView[i] = ImageView(this).apply {

            }

    }
}
