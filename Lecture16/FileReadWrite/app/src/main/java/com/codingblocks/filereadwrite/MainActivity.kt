package com.codingblocks.filereadwrite

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import java.io.File

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.i("FILES", "Files dir ${filesDir.path}")
        val file = File(filesDir, "myfile.text")

        btn.setOnClickListener {
            file.writeText(edtv.text.toString())
            Log.i("FILES", "exists =  ${file.exists()}")
        }

    }
}
