package com.example.bekalmu

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Memanggil wadah utama navigasi kita (activity_main.xml)
        setContentView(R.layout.activity_main)
    }
}