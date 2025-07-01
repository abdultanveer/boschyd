package com.example.boschyd

import androidx.lifecycle.ViewModel

class MainViewmodel:ViewModel() {
    var count = 0

    fun incrementCount(){
        count++
    }
}