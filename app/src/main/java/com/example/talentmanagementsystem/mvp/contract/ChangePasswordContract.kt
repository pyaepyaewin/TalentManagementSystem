package com.example.talentmanagementsystem.mvp.contract

interface ChangePasswordContract {
    interface ChangePasswordView
    {
        fun ChangePasswordSuccess(success:String)
        fun FailChanges(message:String)
    }
    interface ChangePasswordPresenter
    {
        fun attachView(view: ChangePasswordView)
        fun sendPassword(student_id:Int,
                         old_password:String,
                         new_password:String,
                         confirm_password:String)
    }

}