package com.codingblocks.alarms

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    val am by lazy {
        getSystemService(Context.ALARM_SERVICE) as AlarmManager
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val intent = Intent(this, NotifcationClass::class.java)
        val pendingIntent = PendingIntent.getBroadcast(this, 123, intent, PendingIntent.FLAG_UPDATE_CURRENT)

//        am.setRepeating(
//            AlarmManager.RTC,
//            System.currentTimeMillis() + 20000,
//            AlarmManager.INTERVAL_DAY * 7,
//            pendingIntent
//
//        )
        if (Build.VERSION.SDK_INT >= 23)
            am.setExactAndAllowWhileIdle(
                AlarmManager.RTC_WAKEUP,
                System.currentTimeMillis() + 20000,
                pendingIntent

            ) else if (Build.VERSION.SDK_INT >= 19) {
            am.setExact(
                AlarmManager.RTC_WAKEUP,
                System.currentTimeMillis() + 20000,
                pendingIntent

            )
        } else {
            am.set(
                AlarmManager.RTC_WAKEUP,
                System.currentTimeMillis() + 20000,
                pendingIntent

            )
        }
    }
}
