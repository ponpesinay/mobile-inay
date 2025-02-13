package com.example.mobileinay

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

//import com.google.firebase.auth.FirebaseAuth

class ConfirmActivity : AppCompatActivity() {

    private lateinit var etNewPass: EditText
    private lateinit var etConfirmPass: EditText
    private lateinit var btnUpdate: Button
//    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_confirm)

        etNewPass = findViewById(R.id.etPass)
        etConfirmPass = findViewById(R.id.etConfimPass)
        btnUpdate = findViewById(R.id.btnUpdatePass)
//        auth = FirebaseAuth.getInstance()

//        btnUpdate.setOnClickListener {
//            val newPass = etNewPass.text.toString().trim()
//            val confirmPass = etConfirmPass.text.toString().trim()
//
//             if (newPass.isNotEmpty() && confirmPass.isNotEmpty()){
//                 if (newPass == confirmPass){
//                     updatePass(newPass)
//                 }else{
//                     Toast.makeText(this, "Password Salah", Toast.LENGTH_SHORT).show()
//                 }
//             }else{
//                 Toast.makeText(this, "Mohon Masukkan Password", Toast.LENGTH_SHORT).show()
//             }
//        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

//    private fun updatePass(newPass: String) {
//        val user = auth.currentUser
//        if (user != null){
//            user.updatePassword(newPass)
//                .addOnCompleteListener { task ->
//                    if (task.isSuccessful){
//                        Toast.makeText(this, "Passwrod Update Succes", Toast.LENGTH_SHORT).show()
//                        startActivity(Intent(this, LoginActivity::class.java))
//                        finish()
//                    }else{
//                        val errorMessage = task.exception?.message ?: "Proses ganti sandi gagal"
//                        Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show()
//                    }
//                }
//        }else{
//            Toast.makeText(this, "No authenticated user", Toast.LENGTH_SHORT).show()
//        }
//    }
}