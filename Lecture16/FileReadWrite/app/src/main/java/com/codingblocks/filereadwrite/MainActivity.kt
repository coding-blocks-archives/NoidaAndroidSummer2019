package com.codingblocks.filereadwrite

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import java.io.File

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.i("FILES", "Files dir ${getExternalFilesDir(Environment.getDataDirectory().absolutePath)}")

        //System App Directory -  No need to ask for permissions
//        val file = File(getExternalFilesDir(Environment.getDataDirectory().absolutePath), "myfile.text")
        //Downloads Directory - Need to ask permissions for this
        val file = File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), "myfile.text")

        btn.setOnClickListener {
            //            file.writeText(edtv.text.toString())
            file.appendText(edtv.text.toString())
            Log.i("FILES", "exists =  ${file.exists()}")
        }

        restoreBtn.setOnClickListener {
            val existingfile = file.readText()
            edtv.setText(existingfile)
        }

    }
}
