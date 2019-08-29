package com.example.talentmanagementsystem.mvp.contract

import android.os.Message
import com.example.talentmanagementsystem.network_response.Login.Data

interface LoginContract {
    interface LoginView
    {
        fun loginSuccess(user: Data)
        fun loginFail(message: String)
        fun goToPinCodePage()

    }
    interface LoginPresenter
    {
        fun attachView(view: LoginView)

        fun loadLogin(email:String,password: String)



    }
}