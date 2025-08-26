package com.hpnightowl.broaadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast

class MyReciever: BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        val action = intent?.action

        when(action) {
            Intent.ACTION_AIRPLANE_MODE_CHANGED -> {
                val state = intent?.getBooleanExtra("state",false)
                Toast.makeText(context,"State: $state", Toast.LENGTH_LONG)
                Log.d("MyReciever", state.toString())
            }
        }
    }
}
