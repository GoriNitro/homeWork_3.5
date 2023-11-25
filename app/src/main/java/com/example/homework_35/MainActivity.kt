package com.example.homework_35

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
            val mainFragment = MainFragment()
            supportFragmentManager.beginTransaction().replace(R.id.container, mainFragment).commit()

    }
}