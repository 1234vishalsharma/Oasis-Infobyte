package com.example.todolist.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.todolist.activity.ShowActivity
import com.example.todolist.databinding.ListItemBinding
import com.example.todolist.model.listmodel
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener


class listadapter(val context: Context, val list: ArrayList<listmodel>) :
    RecyclerView.Adapter<listadapter.listViewHolder>() {

    inner class listViewHolder(val binding: ListItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): listViewHolder {
        val binding = ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return listViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: listViewHolder, position: Int) {
        val currentItem = list[position]
        holder.binding.textView2.text = currentItem.title
        holder.itemView.setOnClickListener {
            val intent = Intent(context, ShowActivity::class.java)
            intent.putExtra("Title", currentItem.title.toString())
            intent.putExtra("Description", currentItem.desc.toString())
            context.startActivity(intent)
        }
    }
}