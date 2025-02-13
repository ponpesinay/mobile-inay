package com.example.mobileinay

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class MajmuActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_majmu)

        supportActionBar?.hide()

        val btnBack: ImageButton = findViewById(R.id.btn_back)

        btnBack.setOnClickListener {
            finish()
        }
    }
}