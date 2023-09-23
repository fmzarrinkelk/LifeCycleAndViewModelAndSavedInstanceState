package edu.fullerton.fz.cs411.lifecycle01

import android.util.Log
import androidx.lifecycle.ViewModel

class MyViewModel: ViewModel() {
    private var counter = 0
    override fun onCleared() {
        super.onCleared()
        Log.d(TAG, "ViewModel Cleared")
    }
    fun getCounter(): Int {
        return counter
    }
    fun setCounter(c: Int) {
        counter = c
    }
    fun increaseCounter() {
        counter++
    }
    fun decreaseCounter() {
        counter--
    }
}