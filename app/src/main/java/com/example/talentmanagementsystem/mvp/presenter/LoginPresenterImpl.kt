package com.example.talentmanagementsystem.mvp.presenter

import android.content.Context
import com.example.talentmanagementsystem.data.models.LoginModel
import com.example.talentmanagementsystem.data.models.SharedPreference
import com.example.talentmanagementsystem.mvp.contract.LoginContract

class LoginPresenterImpl(val context: Context) : LoginContract.LoginPresenter {
    private lateinit var loginView: LoginContract.LoginView

    private val loginModel: LoginModel by lazy {
        LoginModel.getInstance()
    }

    override fun attachView(view: LoginContract.LoginView) {
        this.loginView = view
    }

    override fun loadLogin(email: String, password: String) {
        loginModel.login(email, password, {
            if (it.code in 200..300) {
                loginView.loginSuccess(it.data)
                SharedPreference.getInstance(context).saveUserId(it.data.id)
                SharedPreference.getInstance(context).saveToken(it.data.token)
                SharedPreference.getInstance(context).setIsLogin("login", true)

            } else {
                loginView.loginFail("Login Fail")
            }
        }, {
            loginView.loginFail("Login Fail!!!")
        })
    }

}
