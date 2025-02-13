package com.example.mobileinay.api.adapter
import android.content.Context
import android.content.SharedPreferences
import android.util.Log

class SessionManager(context: Context) {
    private val prefs: SharedPreferences = context.getSharedPreferences("user_session", Context.MODE_PRIVATE)
    private val editor: SharedPreferences.Editor = prefs.edit()

    fun setToken(token:String?, idUser:String?, name:String?){
        prefs.edit().putString("ACCESS_TOKEN", token).apply()
        prefs.edit().putString("ID_USER", idUser).apply()
        prefs.edit().putString("NAME", name).apply()
    }
    fun getTokenAccess(): String? {
        val token = prefs.getString("ACCESS_TOKEN", null)
        return token
    }

    fun getIdUser(): String? {
        val idUser = prefs.getString("ID_USER", null)
        return idUser
    }

    fun getNameUser(): String? {
        val usrname = prefs.getString("NAME", null)
        return usrname
    }

    fun setkKelas(kelas:String){
        editor.putString("id_kelas", kelas)
        editor.commit()
    }

    fun getKelas():String?{
        return prefs.getString("id_kelas", "")
    }
    fun removeData(){
        prefs.edit().remove("ACCESS_TOKEN").apply()

    }
}
