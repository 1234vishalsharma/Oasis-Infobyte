package com.example.todolist.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.todolist.MainActivity
import com.example.todolist.R
import com.example.todolist.databinding.ActivityShowBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class ShowActivity : AppCompatActivity() {
    private lateinit var binding:ActivityShowBinding
    private lateinit var database:FirebaseDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityShowBinding.inflate(layoutInflater)
        setContentView(binding.root)
        database= FirebaseDatabase.getInstance()
        val title=intent.getStringExtra("Title")
        val desc=intent.getStringExtra("Description")
        binding.editText1.setText(title)
        binding.editText.setText(desc)

        binding.done.setOnClickListener {
            database.reference.child("TODO").addValueEventListener(object:ValueEventListener{
                override fun onDataChange(snapshot: DataSnapshot) {
                    for(snap in snapshot.children){
                        if(snap.child("Title").getValue(String::class.java)==title
                            && snap.child("Description").getValue(String::class.java)==desc){
                            snap.ref.removeValue()
                        }
                    }
                    Toast.makeText(this@ShowActivity, "Item Completed Successfully", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this@ShowActivity,MainActivity::class.java))
                }

                override fun onCancelled(error: DatabaseError) {
                    Toast.makeText(this@ShowActivity, "Item cant be removed $error", Toast.LENGTH_SHORT).show()
                }

            })
        }
        binding.delete.setOnClickListener {
            database.reference.child("TODO").addValueEventListener(object:ValueEventListener{
                override fun onDataChange(snapshot: DataSnapshot) {
                    for(snap in snapshot.children){
                        if(snap.child("Title").getValue(String::class.java)==title
                            && snap.child("Description").getValue(String::class.java)==desc){
                            snap.ref.removeValue()
                        }
                    }
                    Toast.makeText(this@ShowActivity, "Item Deleted", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this@ShowActivity,MainActivity::class.java))
                }

                override fun onCancelled(error: DatabaseError) {
                    Toast.makeText(this@ShowActivity, "Item cant be removed $error", Toast.LENGTH_SHORT).show()
                }

            })
        }
    }
}