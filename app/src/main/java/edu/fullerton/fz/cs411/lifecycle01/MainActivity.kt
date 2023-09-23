package edu.fullerton.fz.cs411.lifecycle01

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider

const val TAG = "MainActivity"
const val COUNTER_KEY = "my counter"

class MainActivity : AppCompatActivity() {

    private lateinit var countText: TextView
    private lateinit var increaseButton: Button
    private lateinit var decreaseButton: Button

    private val counterViewModel: MyViewModel by lazy {
        ViewModelProvider(this)[MyViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate called")
        setContentView(R.layout.activity_main)

        countText = findViewById(R.id.count)

        val currentCounter = savedInstanceState?.getInt(COUNTER_KEY, 0) ?: 0
        counterViewModel.setCounter(currentCounter)

        countText.text = counterViewModel.getCounter().toString()

        increaseButton = findViewById(R.id.increase_count)
        increaseButton.setOnClickListener {
            counterViewModel.increaseCounter()
            countText.text = counterViewModel.getCounter().toString()
        }

        if (this.resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            decreaseButton = findViewById(R.id.decrease_count)
            decreaseButton.setOnClickListener {
                counterViewModel.decreaseCounter()
                countText.text = counterViewModel.getCounter().toString()
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.d(TAG , "instance state saved")
        outState.putInt(COUNTER_KEY, counterViewModel.getCounter())
    }
    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart called")
    }
    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume called")
    }
    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause called")
    }
    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop called")
    }
    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy called")
    }


}