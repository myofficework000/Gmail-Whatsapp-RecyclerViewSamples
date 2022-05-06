package com.example.gmaillikeappusingrecyclerview.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.gmaillikeappusingrecyclerview.ui.DetailActivity
import com.example.gmaillikeappusingrecyclerview.data_layer.MailDetails
import com.example.gmaillikeappusingrecyclerview.databinding.ItemViewBinding
import java.io.Serializable

class MailAdapter(private val context: Context, private val mailDetails: List<MailDetails>) :
    RecyclerView.Adapter<MailAdapter.MailViewHolder>() {

    private lateinit var binding: ItemViewBinding

    /*
     This method needs to override to define the size of recycler view*/
    override fun getItemCount() = mailDetails.size

    /*
    This method will call only once when you create adapter for recycler view.
    Responsibility of this method is to create new views.*/
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MailViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        binding = ItemViewBinding.inflate(layoutInflater, parent, false)
        return MailViewHolder(binding.root)
    }

    /*
    This method will call any number of times when you scroll up or down the list
    Responsibility of this method is to bind the new data with position of list*/
    override fun onBindViewHolder(holder: MailViewHolder, position: Int) {
        holder.apply {
            txtSender.text = mailDetails[position].sender
            txtSubject.text = mailDetails[position].title
            txtBody.text = mailDetails[position].body
            txtTime.text = mailDetails[position].time

            itemView.setOnClickListener {
                val intent =  Intent(context, DetailActivity::class.java)
                intent.putExtra(MAIL_DATA, mailDetails[position] as Serializable)
                context.startActivity(intent)
            }
        }
    }

    inner class MailViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val txtSender: TextView = binding.txtSender
        val txtSubject: TextView = binding.txtSubject
        val txtBody: TextView = binding.txtBody
        val txtTime: TextView = binding.txtTime
    }

    companion object{
        const val MAIL_DATA = "mail data"
    }
}