package com.codingblocks.alarms

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class NotifcationClass : BroadcastReceiver() {
    override fun onReceive(p0: Context?, p1: Intent?) {
        Toast.makeText(p0, "Toast Show", Toast.LENGTH_LONG).show()
    }

}
