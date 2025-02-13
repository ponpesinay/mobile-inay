package com.example.mobileinay

import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.mobileinay.ui.home.HomeActivity

class DatadiriActivity : AppCompatActivity() {
    lateinit var progressDialog: ProgressDialog
//    private var firebaseAuth = FirebaseAuth.getInstance()
//    private var db = FirebaseFirestore.getInstance()
    private lateinit var userEmail: String
    private lateinit var listkelas2: Spinner
    private lateinit var etName: EditText
    private lateinit var etAlamat: EditText
    private lateinit var btnReg: Button


    override fun onStart() {
        super.onStart()
//        db.collection("user").document(userEmail).get()
//            .addOnSuccessListener { document ->
//                if (document.data != null) goToHome()
//            }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_datadiri)

//        val navHostFragment = supportFragmentManager.findFragmentById(R.id.Fragment_home) as NavHostFragment
//        navController = navHostFragment.navController

        etName = findViewById(R.id.etName)
        listkelas2 = findViewById(R.id.etKelas)
        etAlamat = findViewById(R.id.etAlamat)
        btnReg = findViewById(R.id.btnRegister)

//        getDataKelas()

        progressDialog = ProgressDialog(this)
        progressDialog.setTitle("Proses")
        progressDialog.setMessage("Silahkan Tunggu..")

//        val loggedInEmail = firebaseAuth.currentUser?.email
//        if (loggedInEmail != null) {
//            userEmail = loggedInEmail
//        } else {
//            finish()
//        }

        btnReg.setOnClickListener{
            val name = etName.text.toString().trim()
            val kelas = listkelas2.selectedItem.toString()
            val alamat = etAlamat.text.toString().trim()

            if (name.isNotEmpty() && kelas.isNotEmpty() && alamat.isNotEmpty()) {
                insertUser(name, kelas, alamat)
            }else{
                Toast.makeText(this, "Silahkan Isi Semua Data", Toast.LENGTH_SHORT).show()
            }
        }

    }
//    private fun getDataKelas() {
//        CoroutineScope(Dispatchers.IO).launch {
//            try {
//                val kelasCollection = db.collection("kelas")
//                    .get().await()
//                val classList = mutableListOf<String>()
//                for (document in kelasCollection.documents){
//                    document.getString("name")?.let {
//                        classList.add(it)
//                    }
//                }
//                withContext(Dispatchers.Main){
//                    val adapter = ArrayAdapter(this@DatadiriActivity, android.R.layout.simple_spinner_item, classList)
//                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
//                    listkelas2.adapter = adapter
//                }
//
//            } catch (e: Exception) {
//                withContext(Dispatchers.Main) {
//                    Toast.makeText(this@DatadiriActivity, "Error saat mengambil data: ${e.message}", Toast.LENGTH_SHORT).show()
//                }
//            }
//        }
//    }


    private fun goToHome() {
        startActivity(Intent(this, HomeActivity::class.java))
        finish()
    }

    private fun insertUser(nama: String, kelas: String, alamat: String) {
        val userMap = hashMapOf(
            "nama" to nama,
            "kelas" to kelas,
            "alamat" to alamat
        )

//        CoroutineScope(Dispatchers.IO).launch {
//            try {
//                val userBaru = db.collection("user").document(userEmail)
//                userBaru.set(userMap).await()
//
//                withContext(Dispatchers.Main){
//                    Toast.makeText(this@DatadiriActivity, "User Berhasil Didaftarkan", Toast.LENGTH_SHORT).show()
//                    navigateToHomeActivity()
//                }
//            } catch (e: Exception){
//                withContext(Dispatchers.Main){
//                    Toast.makeText(this@DatadiriActivity, "Eror Saat Mendaftarkan user: ${e.message}", Toast.LENGTH_SHORT).show()
//                }
//            }
//        }
//        db.collection("user").document(userEmail).set(userMap)
//            .addOnSuccessListener {
//                goToHome()
//            }
//            .addOnFailureListener {
//                Toast.makeText(this,"Gagal menyimpan data", Toast.LENGTH_SHORT).show()
//            }
    }

    private fun navigateToHomeActivity() {
        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
        finish()
    }

}