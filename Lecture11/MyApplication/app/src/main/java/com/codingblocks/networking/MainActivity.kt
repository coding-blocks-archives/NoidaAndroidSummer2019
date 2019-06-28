package com.codingblocks.networking

import android.os.AsyncTask
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.getData
import kotlinx.android.synthetic.main.activity_main.showData
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getData.setOnClickListener {
            updateTextView()
        }


    }

    private fun updateTextView() {
        val networkTask = NetworkTask()
        networkTask.execute("https://api.github.com/search/users?q=%22Pulkit%20Aggarwal%22", "https://www.github.com/")
    }

    inner class NetworkTask : AsyncTask<String, Int, String>() {


        override fun doInBackground(vararg url: String?): String? {
            val googleUrl: URL = URL(url[0])

            val connection = googleUrl.openConnection() as HttpURLConnection
            val isr = InputStreamReader(connection.inputStream)
            val bufferReader = BufferedReader(isr)
            val sb = StringBuilder()
            var buffer: String? = ""
            while (buffer != null) {
                sb.append(buffer)
                buffer = bufferReader.readLine()
            }
            return sb.toString()


        }


        override fun onPostExecute(result: String?) {

            val jsonData = JSONObject(result)

            showData.text = result
        }
    }
}
