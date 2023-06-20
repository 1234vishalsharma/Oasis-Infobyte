package com.example.todolist.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.todolist.MainActivity
import com.example.todolist.R
import com.example.todolist.databinding.ActivityDetailsBinding
import com.example.todolist.model.listmodel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase

class DetailsActivity : AppCompatActivity() {

    private lateinit var auth:FirebaseAuth
    private lateinit var database:FirebaseDatabase
    private lateinit var binding:ActivityDetailsBinding
    private lateinit var dialog:AlertDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val builder=AlertDialog.Builder(this)
        builder.setTitle("Uploading TODO List...")
        builder.setMessage("Please be patience")
        builder.setCancelable(false)
        dialog=builder.create()

        auth=FirebaseAuth.getInstance()
        database=FirebaseDatabase.getInstance()
        binding.addbtn.setOnClickListener {
            if(binding.editText1.text.toString().isEmpty()){
                binding.editText1.setError("Title is Compulsory")
            }
            else if (binding.editText.text.toString().isEmpty()){
                binding.editText.setError("Required")
            }
            else{
                val title=binding.editText1.text.toString()
                val desc=binding.editText.text.toString()
                addlist(title,desc)
            }
        }
    }
    private fun addlist(title: String, descrip: String){
        dialog.show()
        val key=database.reference.push().key
                database.reference.child("TODO").child(key!!).child("Title").setValue(title)
                    .addOnSuccessListener {
                        database.reference.child("TODO").child(key).child("Description").setValue(descrip)
                            .addOnSuccessListener {
                                dialog.dismiss()
                                Toast.makeText(this, "List Added Successfully", Toast.LENGTH_SHORT).show()
                                startActivity(Intent(this,MainActivity::class.java))
                                finish()
                            }
                            .addOnFailureListener {
                                dialog.dismiss()
                                Toast.makeText(this, "Failure While Adding Description", Toast.LENGTH_SHORT).show()
                            }
                    }
                    .addOnFailureListener {
                        dialog.dismiss()
                        Toast.makeText(this, "Failure While Adding Title", Toast.LENGTH_SHORT).show()
                    }
    }
}