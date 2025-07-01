package com.example.boschyd

import android.os.CountDownTimer
import android.util.Log
import androidx.lifecycle.ViewModel

class MainViewmodel:ViewModel() {
    var TAG = MainViewmodel::class.java.simpleName

    var count = 0
    var _seconds = 0   //_ underscore for mutable variables
   // val seconds = 0  //no underscore for immutable variables

    lateinit var timer: CountDownTimer


    fun incrementCount(){
        count++
    }

    fun startTimer() {
        timer = object :CountDownTimer(10_000,1_000){
            override fun onTick(timeRemaining: Long) {
                _seconds = timeRemaining.toInt()
                Log.i(TAG,"seconds value ="+_seconds)

            }

            override fun onFinish() {
                Log.i(TAG,"counter  stopped")
            }

        }.start()
    }
}