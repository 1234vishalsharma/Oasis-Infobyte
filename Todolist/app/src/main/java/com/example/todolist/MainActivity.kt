package com.example.todolist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.todolist.activity.DetailsActivity
import com.example.todolist.adapter.listadapter
import com.example.todolist.databinding.ActivityMainBinding
import com.example.todolist.model.listmodel
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    private lateinit var list:ArrayList<listmodel>
    private lateinit var database:FirebaseDatabase
    private lateinit var dialog:AlertDialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        list=ArrayList()
        val builder=AlertDialog.Builder(this)
        builder.setTitle("Fetching Data...")
        builder.setMessage("Just a moment")
        builder.setCancelable(false)
        dialog=builder.create()

        database= FirebaseDatabase.getInstance()
        updaterecycler(list)

        binding.floatingActionButton2.setOnClickListener {
            startActivity(Intent(this,DetailsActivity::class.java))
        }

    }

    private fun updaterecycler(list: ArrayList<listmodel>) {
        dialog.show()
        database.reference.child("TODO").addValueEventListener(object:ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                list.clear()
                for(snap in snapshot.children){
                    val title: String? = snap.child("Title").getValue(String::class.java)
                    val desc: String? = snap.child("Description").getValue(String::class.java)
                    list.add(listmodel(title, desc))
                }
                binding.recyclerview.adapter=listadapter(this@MainActivity, list)
                dialog.dismiss()
            }

            override fun onCancelled(error: DatabaseError) {
                dialog.dismiss()
                Toast.makeText(this@MainActivity, "Something went wrong in retriving DB", Toast.LENGTH_SHORT).show()
            }
        })

    }
}