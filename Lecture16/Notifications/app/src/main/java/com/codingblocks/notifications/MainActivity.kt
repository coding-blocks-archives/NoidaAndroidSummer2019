package com.codingblocks.notifications

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.drm.DrmStore
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.NotificationCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nm = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
            nm.createNotificationChannel(
                NotificationChannel(
                    "first",
                    "default",
                    NotificationManager.IMPORTANCE_DEFAULT
                )
            )
        btn1.setOnClickListener {
            val simpleNotfication = NotificationCompat.Builder(this, "first")
                .setContentTitle("Simple Title")
                .setContentText("This is sample description of a simple notification")
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .build()
            nm.notify(System.currentTimeMillis().toInt(), simpleNotfication)
        }

        btn2.setOnClickListener {
            val i = Intent()
            i.action = Intent.ACTION_VIEW
            i.data = Uri.parse("https://www.google.com")

            val pi = PendingIntent.getActivity(this, 123, i, PendingIntent.FLAG_UPDATE_CURRENT)
            val simpleNotfication = NotificationCompat.Builder(this, "first")
                .setContentTitle("Simple Title")
                .setContentText("This is sample description of a simple notification")
                .setContentIntent(pi)
                .setOngoing(true)
                .setAutoCancel(true)
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .build()
            nm.notify(System.currentTimeMillis().toInt(), simpleNotfication)
        }

        btn3.setOnClickListener {
            val i = Intent()
            i.action = Intent.ACTION_VIEW
            i.data = Uri.parse("https://www.google.com")

            val pi = PendingIntent.getActivity(this, 123, i, PendingIntent.FLAG_UPDATE_CURRENT)
            val simpleNotfication = NotificationCompat.Builder(this, "first")
                .setContentTitle("Simple Title")
                .setContentText("This is sample description of a simple notification")
                .addAction(R.drawable.ic_launcher_foreground,"Click ME",pi)
                .setOngoing(true)
                .setAutoCancel(true)
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .build()
            nm.notify(System.currentTimeMillis().toInt(), simpleNotfication)
        }



    }
}
