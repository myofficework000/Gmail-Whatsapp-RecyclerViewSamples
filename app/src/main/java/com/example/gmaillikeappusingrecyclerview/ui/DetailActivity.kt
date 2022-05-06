package com.example.gmaillikeappusingrecyclerview.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.gmaillikeappusingrecyclerview.adapter.MailAdapter.Companion.MAIL_DATA
import com.example.gmaillikeappusingrecyclerview.data_layer.MailDetails
import com.example.gmaillikeappusingrecyclerview.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val mailDetails = intent.extras?.get(MAIL_DATA) as MailDetails

        binding.apply {
            txtSender.text = mailDetails.sender
            txtSubject.text = mailDetails.title
            txtBody.text = mailDetails.body
            txtTime.text = mailDetails.time
        }
    }
}