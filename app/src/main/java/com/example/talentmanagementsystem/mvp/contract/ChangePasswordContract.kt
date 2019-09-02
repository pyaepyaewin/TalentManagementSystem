package com.example.talentmanagementsystem.mvp.contract

interface ChangePasswordContract {
    interface ChangePasswordView
    {
        fun ChangePasswordSuccess(success:String)
        fun ChangedFail(message:String)
    }
    interface ChangePasswordPresenter
    {
        fun attachView(view: ChangePasswordView)
        fun sendPassword(
                         old_password:String,
                         new_password:String,
                         confirm_password:String)
    }

}