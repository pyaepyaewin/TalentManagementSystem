package com.example.talentmanagementsystem.mvp.contract

import android.provider.ContactsContract

interface RegisterContract {
    interface RegisterView
    {
        fun goToLoginPage()
        fun showError(error:String)
    }
    interface RegisterPresenter
    {
        fun attachView(view: RegisterView)

    }
}