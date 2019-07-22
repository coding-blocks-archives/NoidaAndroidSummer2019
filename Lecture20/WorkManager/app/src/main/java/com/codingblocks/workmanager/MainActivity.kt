package com.codingblocks.workmanager

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.media.AudioAttributes
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.util.concurrent.TimeUnit
import android.media.RingtoneManager
import androidx.work.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nm = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            val defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
            val notificationChannel = NotificationChannel("first","default",NotificationManager.IMPORTANCE_HIGH)
            val att = AudioAttributes.Builder()
                .setUsage(AudioAttributes.USAGE_NOTIFICATION)
                .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                .build()
            notificationChannel.setSound(defaultSoundUri, att)
            nm.createNotificationChannel(notificationChannel)
        }

        requestOneTimeTask()
        requestRepeptiveTask()

    }

    private fun requestRepeptiveTask() {

        val workRequest = PeriodicWorkRequestBuilder<NotificationWorker>(1,TimeUnit.DAYS)
            .build()

        WorkManager.getInstance(this).enqueue(workRequest)    }

    private fun requestOneTimeTask() {
        val constraints = Constraints.Builder().apply {
            setRequiredNetworkType(NetworkType.UNMETERED)
            setRequiresCharging(true)
            setRequiresDeviceIdle(false)
            setRequiresStorageNotLow(true)
        }.build()

        val workRequest = OneTimeWorkRequestBuilder<NotificationWorker>()
            .build()

        WorkManager.getInstance(this).enqueue(workRequest)
    }
}
