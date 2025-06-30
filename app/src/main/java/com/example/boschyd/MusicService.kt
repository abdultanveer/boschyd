package com.example.boschyd

import android.app.Service
import android.content.Intent
import android.nfc.Tag
import android.os.Binder
import android.os.IBinder
import android.util.Log

class MusicService : Service() {
var TAG = MusicService::class.java.name

    private val nbinder = LocalBinder()

    override fun onCreate() {
        super.onCreate()
        Log.i(TAG,"service created")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
         super.onStartCommand(intent, flags, startId)
        Log.i(TAG,"service started")
        return  START_STICKY

    }

    fun addMusicService(firstNo:Int,secondNo:Int):Int{
        return firstNo + secondNo
    }

    fun getCricScore():Int{
        return 192
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(TAG,"service destroyed")

    }

    override fun onBind(intent: Intent): IBinder {
        return nbinder
    }

    //binder = glue= pipe
    inner class LocalBinder : Binder() {

        // Return this instance of MusicService so clients can call public methods.
        fun getService(): MusicService
        {
            return  this@MusicService
        }
    }
}