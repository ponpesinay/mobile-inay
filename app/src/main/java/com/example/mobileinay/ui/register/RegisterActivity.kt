package com.example.mobileinay.ui.register

import android.app.ProgressDialog
import android.os.Bundle
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import androidx.appcompat.app.AppCompatActivity
import com.example.mobileinay.databinding.ActivityRegisterBinding

//import com.google.firebase.auth.FirebaseAuth
//import com.google.firebase.auth.userProfileChangeRequest
//import com.google.firebase.firestore.FirebaseFirestore

class RegisterActivity : AppCompatActivity() {
    private lateinit var progressDialog: ProgressDialog
//    private var firebaseAuth = FirebaseAuth.getInstance()
//    private lateinit var db: FirebaseFirestore
    private lateinit var registerBinding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        registerBinding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(registerBinding.root)
        supportActionBar?.hide()

        progressDialog = ProgressDialog(this)
        progressDialog.setTitle("Proses")
        progressDialog.setMessage("Silahkan Tunggu..")

        registerBinding.btnReg.setOnClickListener{
            if (registerBinding.TeiEmail.text.isNotEmpty() && registerBinding.TeiPass.text.isNotEmpty()){
                if (registerBinding.TeiPass.text.toString() == registerBinding.TeiConfPass.text.toString()){
                    //Menampilkan Register
                    processRegister()
                }else{
                    Toast.makeText(this, "Konfirmasi kata sandi harus sama" ,LENGTH_SHORT).show()
                }
            }else{
                Toast.makeText(this, "Silahkan Isi dulu Semua datanya" , LENGTH_SHORT).show()
            }
        }
    }
    private fun processRegister(){
//        val email = registerBinding.TeiEmail.text.toString()
//        val pass = registerBinding.TeiPass.text.toString()
//
//        progressDialog.show()
//        firebaseAuth.createUserWithEmailAndPassword(email, pass)
//            .addOnCompleteListener { task ->
//                if (task.isSuccessful){
//                    this.finish()
//                }else{
//                    progressDialog.dismiss()
//                }
//            }
//            .addOnFailureListener { error ->
//                Toast.makeText(this, error.localizedMessage, LENGTH_SHORT).show()
//            }
    }
}