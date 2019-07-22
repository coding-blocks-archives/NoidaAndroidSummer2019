package com.codingblocks.broadcastrecievers

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class NetworkReciever : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent) {
        when (intent.action){
            Intent.ACTION_AIRPLANE_MODE_CHANGED ->{
                Toast.makeText(context,"Airplane mode Changed",Toast.LENGTH_LONG).show()
            }
        }
    }

}