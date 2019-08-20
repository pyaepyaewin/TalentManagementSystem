package com.example.talentmanagementsystem.mvp.contract

interface LoginContract {
    interface LoginView
    {
        fun showError(error:String)
        fun goToMainPage()
        fun goToRegisterPage()
    }
    interface LoginPresenter
    {
        fun attachView(view: LoginView)
        fun checkValidate(email:String,password:String)
    }
}