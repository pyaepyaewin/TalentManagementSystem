package com.example.talentmanagementsystem.mvp.contract

interface RegisterContract {
    interface RegisterView
    {
        //fun goToLoginPage()
        fun registerSuccess(message: String)
        fun registerFail(message: String)
    }
    interface RegisterPresenter
    {
        fun attachView(view: RegisterView)
        fun loadRegisterData(name:String,
                             email:String,
                             password:String,
                             confirm_password:String,
                             phone:String,
                             date_of_birth: String,
                             module_id:Int, address:String)

    }
}