package com.example.webview

import android.content.Context
import android.content.SharedPreferences

class SessionManager(context: Context) {

    private val keyName: String = "name"
    private val keyEmail: String = "email"

    var sharedPreferences: SharedPreferences? = null
    var editor: SharedPreferences.Editor? = null

    val name: String? get() = sharedPreferences?.getString(keyName,null)
    val email: String? get() = sharedPreferences?.getString(keyEmail,null)

    fun sessionLogin(name: String, email: String) {
        editor?.putString(keyName, name)
        editor?.putString(keyEmail, email)
        editor?.apply()
    }
    fun sessionLogout() {
        editor?.remove(keyName)
        editor?.remove(keyEmail)
        editor?.apply()
    }
    fun isLogin(): Boolean {
        return !(name.isNullOrEmpty() && email.isNullOrEmpty())
    }

    init {
        sharedPreferences = context.getSharedPreferences("login", Context.MODE_PRIVATE)
        editor = sharedPreferences?.edit()
    }
}