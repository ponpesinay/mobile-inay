package com.example.mobileinay

import android.os.Bundle
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class EditDataActivity : AppCompatActivity() {
    private lateinit var listkelas2: Spinner
    private lateinit var textKelas: TextView
//    private lateinit var auth:FirebaseAuth
//    private lateinit var db:FirebaseFirestore

        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_edit_data)

            listkelas2 = findViewById(R.id.listKelas)
            textKelas = findViewById(R.id.textViewGrades)
//            auth = FirebaseAuth.getInstance()
//            db = FirebaseFirestore.getInstance()

            getDataKelas()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun getDataKelas() {
//        val kelasData = db.collection("kelas")
//
//        kelasData.get()
//            .addOnSuccessListener { documents ->
//                val kelasList = mutableListOf<String>()
//                for (document in documents){
//                    val kelasName = document.getString("name")
//                    kelasName?.let { kelasList.add(it) }
//                }
//                val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, kelasList)
//                adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line)
//                listkelas2.adapter = adapter
//            }
//            .addOnFailureListener { exception ->
//                exception.printStackTrace()
//            }
    }
}