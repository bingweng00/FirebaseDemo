package com.example.firebasedemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.btnInsert).setOnClickListener() {
            val database: FirebaseDatabase = FirebaseDatabase.getInstance()
            val myRef: DatabaseReference = database.getReference("Student")

            myRef.child("A0001").setValue("Weng")
        }

        findViewById<Button>(R.id.btnGet).setOnClickListener() {
            val database: FirebaseDatabase = FirebaseDatabase.getInstance()
            val myRef: DatabaseReference = database.getReference("Student")

            myRef.child("A0001").get().addOnSuccessListener {

                Toast.makeText(applicationContext, it.value.toString(), Toast.LENGTH_SHORT).show()

            }
        }
    }



}