package com.example.mobileinay

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class RaportActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_raport)
        supportActionBar?.hide()

        val btnBack: ImageButton = findViewById(R.id.imageback)

        btnBack.setOnClickListener {
            finish()
        }
    }
}