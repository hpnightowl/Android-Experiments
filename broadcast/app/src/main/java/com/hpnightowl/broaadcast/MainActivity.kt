package com.hpnightowl.broaadcast

import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity: AppCompatActivity() {

    private lateinit var myReciever: MyReciever

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        myReciever = MyReciever()
        val filter = IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED)
        registerReceiver(myReciever,filter)
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(myReciever)
    }
}