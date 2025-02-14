package com.example.mobileinay.ui.login

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.annotation.RequiresExtension
import androidx.appcompat.app.AppCompatActivity
import com.example.mobileinay.R
import com.example.mobileinay.api.adapter.SessionManager
import com.example.mobileinay.api.model.LoginRequest
import com.example.mobileinay.api.model.LoginResponse
import com.example.mobileinay.retrofit.RetrofitClient
import com.example.mobileinay.ui.home.HomeActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {
    private lateinit var sessionManager: SessionManager

    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        supportActionBar?.hide()

        sessionManager = SessionManager(this)

        if (sessionManager.dataLogin()){
            startActivity(Intent(this, HomeActivity::class.java))
            finish()
        }

        val nisEditText = findViewById<EditText>(R.id.Tei_email)
        val passwordEditText = findViewById<EditText>(R.id.Tei_pass)
        val loginButton = findViewById<Button>(R.id.btn_login)

        loginButton.setOnClickListener {
            val idSantri = nisEditText.text.toString().trim()
            val password = passwordEditText.text.toString().trim()

            if (idSantri.isEmpty()) {
                Toast.makeText(this, "Nis Tidak Boleh Kososng", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (password.isEmpty()) {
                Toast.makeText(this, "Password tidak boleh kosong", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            loginUser(idSantri, password)
        }
    }

    private fun loginUser(idSantri: String, password: String) {
        val loginRequest = LoginRequest(id_santri = idSantri, password)

        RetrofitClient.instance.loginUser(loginRequest)
            .enqueue(object : Callback<LoginResponse> {
                override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                    if (response.isSuccessful) {
                        val loginResponse = response.body()
                        Log.d("LoginResponse", "Response: $loginResponse")
                        val accessToken = loginResponse?.access_token
                        val idUser = loginResponse?.id_user
                        val name = loginResponse?.name

                        if (accessToken != null && idUser != null && name != null) {
                            sessionManager.saveUserSession(accessToken, idUser, name)

                            Log.d("LoginSuccess", "Token: $accessToken")
                            Log.d("LoginSuccess", "Navigating to HomeActivity")

                            val intent = Intent(this@LoginActivity, HomeActivity::class.java)
                            startActivity(intent)
                            finish()
                        } else {
                            Toast.makeText(this@LoginActivity, "Login Gagal : Data tidak Lengkap", Toast.LENGTH_SHORT).show()
                            Log.e("LoginError", "Response message: ${loginResponse?.message}")
                        }
                    } else {
                        Toast.makeText(this@LoginActivity, "Error: ${response.message()}", Toast.LENGTH_SHORT).show()
                        Log.e("LoginError", "Error code: ${response.code()}, message: ${response.errorBody()?.string()}")
                    }
                }

                override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                    Toast.makeText(this@LoginActivity, "Gagal terhubung: ${t.localizedMessage}", Toast.LENGTH_SHORT).show()
                    Log.e("LoginFailure", "Error: ${t.localizedMessage}")
                }
            })
    }
}
