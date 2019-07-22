package com.codingblocks.workmanager

import android.app.Notification
import android.app.NotificationManager
import android.content.Context
import androidx.core.app.NotificationCompat
import androidx.core.content.getSystemService
import androidx.work.Worker
import androidx.work.WorkerParameters
import android.media.AudioAttributes



class NotificationWorker(val context: Context, workParams: WorkerParameters) : Worker(context, workParams) {
    override fun doWork(): Result {

        val nm = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        val notification = NotificationCompat.Builder(context,"first").apply {
            setContentTitle("Background Task")
            setContentText("Simple notification")
            setSmallIcon(R.drawable.ic_launcher_foreground)
            priority = NotificationManager.IMPORTANCE_HIGH
            setDefaults(Notification.DEFAULT_ALL)
        }.build()

        nm.notify(System.currentTimeMillis().toInt(),notification)

        return Result.success()
    }

}