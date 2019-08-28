package com.example.talentmanagementsystem.mvp.contract

import com.example.talentmanagementsystem.network_response.PinCode.Data

interface PinCodeContract {
    interface PinCodeView
    {
        fun goToRegisterPage()
        fun pinCodeSuccess(user: List<Data>)
        fun pinCodeFail(message:String)
    }
    interface PinCodePresenter
    {
       fun attachView(view: PinCodeView)
        fun loadPin(pin:Int)
    }
}