package com.example.talentmanagementsystem.data.models

import android.content.Context

class SharedPreference(context: Context) {
    private val sharedPreference = context.getSharedPreferences(PREFERENCENAME, Context.MODE_PRIVATE)

    companion object {

        const val PREFERENCENAME = "sharedPreference"
        const val USERID="id"
        const val TOKEN="token"
        private var instance: SharedPreference? = null

        fun getInstance(context: Context): SharedPreference {
            if (instance == null) {
                instance = SharedPreference (context)
            }
            return instance!!
        }}

    fun setIsFirst(key:String,value:Boolean)
    {
        val editor=this.sharedPreference.edit()
        editor?.putBoolean(key,value)
        editor?.apply()
    }
    fun isFirst(key: String):Boolean
    {
        return sharedPreference.getBoolean(key,true)
    }
    fun setIsLogin(key: String,value: Boolean)
    {
        val editor=this.sharedPreference.edit()
        editor.putBoolean(key,value)
        editor?.apply ()
    }
    fun isLogin(key: String):Boolean
    {
        return sharedPreference.getBoolean(key,false)
    }
    fun saveUserId(id:Int)
    {
        sharedPreference.edit().putInt(USERID,id).apply()
    }
    fun getUserId():Int
    {
        return sharedPreference.getInt(USERID,0)
    }
    fun saveToken(token:String)
    {
        sharedPreference.edit().putString(TOKEN,token).apply()
    }
    fun getToken():String
    {
        return sharedPreference.getString(TOKEN,"").toString()
    }
}