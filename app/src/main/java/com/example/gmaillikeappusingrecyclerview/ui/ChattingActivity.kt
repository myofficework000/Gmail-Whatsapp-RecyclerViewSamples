package com.example.gmaillikeappusingrecyclerview.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gmaillikeappusingrecyclerview.adapter.ChatAdapter
import com.example.gmaillikeappusingrecyclerview.data_layer.Chat
import com.example.gmaillikeappusingrecyclerview.databinding.ActivityChattingBinding

class ChattingActivity : AppCompatActivity() {
    private lateinit var binding: ActivityChattingBinding
    private lateinit var chatAdapter: ChatAdapter
    private lateinit var listOfChats: ArrayList<Chat>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChattingBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setRecyclerView()
        addMoreChat()
    }

    private fun setRecyclerView() {
        listOfChats = ArrayList()
        listOfChats.add(Chat(1, "Hey Abhishek, How are you?"))
        listOfChats.add(Chat(2, "I am good"))
        listOfChats.add(Chat(2, "how about you?"))
        listOfChats.add(Chat(1, "What is your fav food?"))
        listOfChats.add(Chat(2, "Pizza"))
        listOfChats.add(Chat(2, "Cake"))
        chatAdapter = ChatAdapter(this, listOfChats)
        binding.apply {
            recyclerViewChatting.layoutManager = LinearLayoutManager(this@ChattingActivity)
            recyclerViewChatting.adapter = chatAdapter
        }
    }

    private fun addMoreChat() {
        binding.apply {
            sendMessage1.setOnClickListener {
                listOfChats.add(Chat(1, edtMessage.text.toString()))
                chatAdapter.notifyItemInserted(listOfChats.size)
                edtMessage.text?.clear()
            }
            sendMessage2.setOnClickListener {
                listOfChats.add(Chat(2, edtMessage.text.toString()))
                chatAdapter.notifyItemInserted(listOfChats.size)
                edtMessage.text?.clear()
            }
        }
    }
}