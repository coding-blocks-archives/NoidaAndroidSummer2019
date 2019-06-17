package com.codingblocks.sharedpreferences

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.edit
import kotlinx.android.synthetic.main.activity_main.editText
import kotlinx.android.synthetic.main.activity_main.restoreBtn
import kotlinx.android.synthetic.main.activity_main.saveBtn
import kotlinx.android.synthetic.main.activity_main.textView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val prefs = getPreferences(Context.MODE_PRIVATE)


        var appOpenCount = 0
        appOpenCount = prefs.getInt("Count",0)
        appOpenCount++

        prefs.edit{
            putInt("Count",appOpenCount)
        }

        textView.text = appOpenCount.toString()


        saveBtn.setOnClickListener {

            //prefs.edit().putString("Name", editText.text.toString()).apply()

            prefs.edit {
                putString("Name", editText.text.toString())

            }

        }

        restoreBtn.setOnClickListener {
            editText.setText(prefs.getString("Name", ""))
        }


    }
}
