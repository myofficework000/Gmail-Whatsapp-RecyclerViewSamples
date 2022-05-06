package com.example.gmaillikeappusingrecyclerview.ui

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gmaillikeappusingrecyclerview.adapter.MailAdapter
import com.example.gmaillikeappusingrecyclerview.data_layer.MailDetails
import com.example.gmaillikeappusingrecyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var mailAdapter: MailAdapter
    private val mailList = ArrayList<MailDetails>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        makeData()
    }

    private fun makeData(){
        mailList.apply {
            add(MailDetails("Facebook","Pocked new user","You have new friends suggestions","12:22 AM",false))
            add(MailDetails("Amazon","Avengers","You have new friends suggestions? how about you","12:22 AM",true))
            add(MailDetails("Google","Rock","You have new friends suggestions","1:22 AM",false))
            add(MailDetails("Patrick@appolis.com","Android discussion call at 8 AM morning","Hey patrick, \n Good day!! \n Hope you are doing well!!, Mountains are degrading,please do needful work here in this app hey how are your i am working with you a log You have new friends suggestions, hey i am happy to work with you, \n\n\n  Regards, \n Abhishek Pathak \n Android Lead ","1:22 AM",false))
            add(MailDetails("Jack","please do needful work here in this app","You have new friends suggestions","12:22 AM",true))
            add(MailDetails("Bob","look like app is working fine to me","You have new friends suggestions","12:33 AM",false))
            add(MailDetails("Uncle","Pocked new user","You have new friends suggestions","12:42 AM",true))
            add(MailDetails("Hero","What you are working here in this country","You have new friends suggestions for an user of an list of data","12:22 AM",false))
        }

        mailAdapter = MailAdapter(this, mailList)

        binding.apply {
            recyclerViewFruits.layoutManager = LinearLayoutManager(this@MainActivity)
            recyclerViewFruits.adapter = mailAdapter
        }

        ItemTouchHelper(object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val position = viewHolder.adapterPosition
                mailList.removeAt(position)
                mailAdapter.notifyItemRemoved(position)
                Toast.makeText(this@MainActivity, "Item deleted", Toast.LENGTH_SHORT).show()
            }
        }).attachToRecyclerView(binding.recyclerViewFruits)
        ItemTouchHelper(object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.RIGHT) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val position = viewHolder.adapterPosition
                mailList.removeAt(position)
                mailAdapter.notifyItemRemoved(position)
                Toast.makeText(this@MainActivity, "Item Archived", Toast.LENGTH_SHORT).show()
            }
        }).attachToRecyclerView(binding.recyclerViewFruits)
    }
}