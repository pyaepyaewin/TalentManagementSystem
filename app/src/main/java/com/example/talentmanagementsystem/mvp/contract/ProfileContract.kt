package com.example.talentmanagementsystem.mvp.contract

interface ProfileContract {
    interface ProfileView
    {
        fun goToLoginPage()
        fun goToChangePasswordPage()
    }
    interface ProfilePresenter
    {
        fun attachView(view: ProfileView)
    }
}