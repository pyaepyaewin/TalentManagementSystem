package com.example.talentmanagementsystem.data.models

import android.content.Context
import com.example.talentmanagementsystem.network_response.Login.Data

class SharedPreference(context: Context) {
    private val sharedPreference = context.getSharedPreferences(PREFERENCENAME, Context.MODE_PRIVATE)

    companion object {

        const val PREFERENCENAME = "sharedPreference"
        const val USERID = "id"
        const val TOKEN = "token"
        const val NAME = "name"
        const val EMAIL = "email"
        const val ADDRESS = "address"
        const val PHONE = "phone"
        const val MODULE = "module"
        const val DOB = "dob"
        const val PHOTO = "photo"
        private var instance: SharedPreference? = null

        fun getInstance(context: Context): SharedPreference {
            if (instance == null) {
                instance = SharedPreference(context)
            }
            return instance!!
        }
    }

    fun setIsFirst(key: String, value: Boolean) {
        val editor = this.sharedPreference.edit()
        editor?.putBoolean(key, value)
        editor?.apply()
    }

    fun isFirst(key: String): Boolean {
        return sharedPreference.getBoolean(key, true)
    }

    fun setIsLogin(key: String, value: Boolean) {
        val editor = this.sharedPreference.edit()
        editor.putBoolean(key, value)
        editor?.apply()
    }

    fun isLogin(key: String): Boolean {
        return sharedPreference.getBoolean(key, false)
    }

    fun saveUserId(id: Int) {
        sharedPreference.edit().putInt(USERID, id).apply()
    }

    fun getUserId(): Int {
        return sharedPreference.getInt(USERID, 0)
    }

    fun saveUserName(userName: String) {
        sharedPreference.edit().putString(NAME, userName).apply()
    }

    fun saveEmail(email: String) {
        sharedPreference.edit().putString(EMAIL, email).apply()
    }

    fun savePhone(phone: String) {
        sharedPreference.edit().putString(PHONE, phone).apply()
    }

    fun saveAddress(address: String) {
        sharedPreference.edit().putString(ADDRESS, address).apply()
    }

    fun saveModule(module: String) {
        sharedPreference.edit().putString(MODULE, module).apply()
    }

    fun saveDate(dob: String) {
        sharedPreference.edit().putString(DOB, dob).apply()
    }

    fun savePhoto(photo: String) {
        sharedPreference.edit().putString(PHOTO, photo).apply()
    }


    fun getUserName(): String {
        return sharedPreference.getString(NAME, "").toString()
    }

    fun getEmail(): String {
        return sharedPreference.getString(EMAIL, "").toString()
    }

    fun getAddress(): String {
        return sharedPreference.getString(ADDRESS, "").toString()
    }

    fun getPhone(): String {
        return sharedPreference.getString(PHONE, "").toString()
    }

    fun getPhoto(): String {
        return sharedPreference.getString(PHOTO, "").toString()
    }

    fun getModule(): String {
        return sharedPreference.getString(MODULE,"").toString()
    }

    fun getDob(): String {
        return sharedPreference.getString(DOB,"").toString()
    }


    fun saveToken(token: String) {
        sharedPreference.edit().putString(TOKEN, token).apply()
    }

    fun getToken(): String {
        return sharedPreference.getString(TOKEN, "").toString()
    }
}