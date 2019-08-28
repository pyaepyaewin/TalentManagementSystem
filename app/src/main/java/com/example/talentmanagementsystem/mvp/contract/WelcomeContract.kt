package com.example.talentmanagementsystem.mvp.contract

interface WelcomeContract {
    interface WelcomeView
    {
        fun goToLoginPage()
    }
    interface WelcomePresenter
    {
        fun attachView(view:WelcomeView)
    }
}