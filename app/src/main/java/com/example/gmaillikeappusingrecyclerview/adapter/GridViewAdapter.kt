package com.example.gmaillikeappusingrecyclerview.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.gmaillikeappusingrecyclerview.data_layer.Sports
import com.example.gmaillikeappusingrecyclerview.databinding.GridViewItemBinding


class GridViewAdapter(private val sports: List<Sports>) :
    RecyclerView.Adapter<GridViewAdapter.GridViewHolder>() {

    private lateinit var binding: GridViewItemBinding

    /*
     This method needs to override to define the size of recycler view*/
    override fun getItemCount() = sports.size

    /*
    This method will call only once when you create adapter for recycler view.
    Responsibility of this method is to create new views.*/
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GridViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        binding = GridViewItemBinding.inflate(layoutInflater, parent, false)
        return GridViewHolder(binding.root)
    }

    /*
    This method will call any number of times when you scroll up or down the list
    Responsibility of this method is to bind the new data with position of list*/
    override fun onBindViewHolder(holder: GridViewHolder, position: Int) {
        holder.apply {
            txtSender.text = sports[position].name
            image.setImageResource(sports[position].image)
        }
    }

    inner class GridViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val txtSender: TextView = binding.txtName
        val image: ImageView = binding.image
    }
}