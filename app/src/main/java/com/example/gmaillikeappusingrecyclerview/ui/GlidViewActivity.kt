package com.example.gmaillikeappusingrecyclerview.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.gmaillikeappusingrecyclerview.R
import com.example.gmaillikeappusingrecyclerview.adapter.GridViewAdapter
import com.example.gmaillikeappusingrecyclerview.data_layer.Sports
import com.example.gmaillikeappusingrecyclerview.databinding.ActivityGlidViewBinding

class GlidViewActivity : AppCompatActivity() {
    private lateinit var binding: ActivityGlidViewBinding
    private lateinit var gridViewAdapter: GridViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGlidViewBinding.inflate(layoutInflater)
        setContentView(binding.root)
        makeData()
    }

    private fun makeData() {

        val sports = ArrayList<Sports>()
        sports.add(Sports("Cricket", R.drawable.ic_baseline_sports_cricket_24))
        sports.add(Sports("Football", R.drawable.ic_baseline_sports_football_24))
        sports.add(Sports("Hockey", R.drawable.ic_baseline_sports_cricket_24))
        sports.add(Sports("tennis", R.drawable.ic_baseline_sports_tennis_24))
        sports.add(Sports("Volleyball", R.drawable.ic_baseline_sports_volleyball_24))
        sports.add(Sports("Cricket", R.drawable.ic_baseline_sports_cricket_24))
        sports.add(Sports("Football", R.drawable.ic_baseline_sports_football_24))
        sports.add(Sports("Hockey", R.drawable.ic_baseline_sports_cricket_24))
        sports.add(Sports("tennis", R.drawable.ic_baseline_sports_tennis_24))
        sports.add(Sports("Volleyball", R.drawable.ic_baseline_sports_volleyball_24))
        sports.add(Sports("Cricket", R.drawable.ic_baseline_sports_cricket_24))
        sports.add(Sports("Football", R.drawable.ic_baseline_sports_football_24))
        sports.add(Sports("Hockey", R.drawable.ic_baseline_sports_cricket_24))
        sports.add(Sports("tennis", R.drawable.ic_baseline_sports_tennis_24))
        sports.add(Sports("Volleyball", R.drawable.ic_baseline_sports_volleyball_24))

        gridViewAdapter = GridViewAdapter(sports)

        binding.apply {
            recyclerViewFruits.layoutManager = GridLayoutManager(this@GlidViewActivity, 3)
            recyclerViewFruits.adapter = gridViewAdapter
        }
    }
}