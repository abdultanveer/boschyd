package com.example.boschyd

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log

class SmsReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        Log.i(TAG,"abdul u have an sms")
    }

    companion object{
        var TAG = SmsReceiver::class.java.simpleName
    }

}