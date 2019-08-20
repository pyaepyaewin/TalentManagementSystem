package com.example.talentmanagementsystem.mvp.presenter

import com.example.talentmanagementsystem.mvp.contract.RegisterContract

class RegisterPresenterImpl:RegisterContract.RegisterPresenter {


    private lateinit var registerView: RegisterContract.RegisterView
    override fun attachView(view: RegisterContract.RegisterView) {
        this.registerView=view

    }
}