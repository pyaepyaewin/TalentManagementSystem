package com.example.talentmanagementsystem.mvp.presenter

import android.widget.Toast
import com.example.talentmanagementsystem.mvp.contract.LoginContract

class LoginPresenterImpl : LoginContract.LoginPresenter {
    private lateinit var loginView: LoginContract.LoginView
    override fun attachView(view: LoginContract.LoginView) {
        this.loginView = view

    }

    override fun checkValidate(email: String, password: String) {
        if (email.equals("aa") && password.equals("123456")) {
            loginView.goToMainPage()
        } else
            loginView.showError("Enter validate email and password")
    }
}