package com.example.mobileinay.api.adapter
import android.content.Context
import android.content.SharedPreferences
import android.util.Log

class SessionManager(context: Context) {
    private val Prefs_Name = "user_session"
    private val SimpanData = "is_login"
    private val SimpenToken = "access_token"
    private val SimpanIdUser = "user_id"
    private val SImpanNamaUser = "user_name"
//    private val SimpanNamaKelas = "user_kelas"

    private val prefs: SharedPreferences = context.getSharedPreferences(Prefs_Name, Context.MODE_PRIVATE)
    private val editor: SharedPreferences.Editor = prefs.edit()

    fun saveUserSession(token: String?, userId: String?, userName:String?){
        editor.putBoolean(SimpanData, true)
        editor.putString(SimpenToken, token)
        editor.putString(SimpanIdUser, userId)
        editor.putString(SImpanNamaUser, userName)
//        editor.putString(SimpanNamaKelas, kelas)
        editor.apply()
    }

//    fun setToken(token:String?, idUser:String?, name:String?){
//        prefs.edit().putString("ACCESS_TOKEN", token).apply()
//        prefs.edit().putString("ID_USER", idUser).apply()
//        prefs.edit().putString("NAME", name).apply()
//    }
    fun dataLogin(): Boolean{
        return prefs.getBoolean(SimpanData, false)
    }
    fun getTokenAccess(): String? {
//        val token = prefs.getString("ACCESS_TOKEN", null)
        return prefs.getString(SimpenToken, null)
    }

    fun getIdUser(): String? {
//        val idUser = prefs.getString("ID_USER", null)
        return prefs.getString(SimpanIdUser, null)
    }

    fun getNameUser(): String? {
//        val usrname = prefs.getString("NAME", null)
        return prefs.getString(SImpanNamaUser, null)
    }

    fun logout(){
        editor.clear()
        editor.apply()
    }
}
