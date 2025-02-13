package com.example.mobileinay

import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.mobileinay.databinding.ActivityLupaSandiBinding

class LupaSandiActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLupaSandiBinding
    private lateinit var etEmail: EditText
    private lateinit var btnResetPass: Button
//    private lateinit var auth:FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLupaSandiBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)

        binding.btnReset.setOnClickListener {
            val email = binding.etEmail.text.toString()
            val edtEmail = binding.etEmail

            if (email.isEmpty()) {
                edtEmail.error = "Email tidak boleh kosong"
                edtEmail.requestFocus()
                return@setOnClickListener
            }
            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                edtEmail.error = "Masukkan email yang valid"
                edtEmail.requestFocus()
                return@setOnClickListener
            }

//            FirebaseAuth.getInstance().sendPasswordResetEmail(email).addOnCompleteListener {
//                if (it.isSuccessful){
//                    Toast.makeText(this, "Reset password url berhasil di kirim", Toast.LENGTH_SHORT).show()
//                    startActivity(Intent(this, LoginActivity::class.java))
//                    finish()
//                }else{
//                    edtEmail.error = "${it.exception?.message}"
//                    edtEmail.requestFocus()
//                    return@addOnCompleteListener
//                }
//            }
        }

//        etEmail = findViewById(R.id.etEmail)
//        btnResetPass = findViewById(R.id.btnReset)
//        auth = FirebaseAuth.getInstance()
//
//        btnResetPass.setOnClickListener {
//            val email = etEmail.text.toString().trim()
//            if (email.isEmpty()){
//                email.error =
//            }else{
//                Toast.makeText(this, "Masukkan Email Anda", Toast.LENGTH_SHORT).show()
//            }
//        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

//    private fun resetPassword(email: String) {
//        auth.sendPasswordResetEmail(email)
//            .addOnCompleteListener { task ->
//                if (task.isSuccessful){
//                    Toast.makeText(this, "Periksa email anda untuk mereset password", Toast.LENGTH_SHORT).show()
//                    startActivity(Intent(this, ConfirmActivity::class.java))
//                    finish()
//                }else{
//
//                    Toast.makeText(this, "Proses reset gagal", Toast.LENGTH_SHORT).show()
//                }
//            }
//    }
}