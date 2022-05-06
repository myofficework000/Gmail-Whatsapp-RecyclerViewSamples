package com.example.gmaillikeappusingrecyclerview.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.gmaillikeappusingrecyclerview.databinding.ActivitySplashScreenBinding

class SplashScreen : AppCompatActivity() {
    private lateinit var binding: ActivitySplashScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.radioButton1.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }

        binding.radioButton2.setOnClickListener {
            startActivity(Intent(this, ChattingActivity::class.java))
        }

        binding.radioButton3.setOnClickListener {
            startActivity(Intent(this, GlidViewActivity::class.java))
        }
    }
}