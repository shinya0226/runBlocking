package com.example.runblocking

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {

    val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d(TAG, "Before runBlocking")
        runBlocking {//5秒の遅延（同時にlaunchメソッドが起動）
            launch(Dispatchers.IO) {
                delay(3000L)//3秒の遅延
                Log.d(TAG, "Finished IO Coroutine 1")
            }
            launch(Dispatchers.IO) {
                delay(3000L)//3秒の遅延
                Log.d(TAG, "Finished IO Coroutine 2")
            }
            Log.d(TAG, "Start of runBlocking")
            delay(5000L)//5秒の遅延
            Log.d(TAG, "End of runBlocking")
        }
        Log.d(TAG, "After runBlocking")
    }
}