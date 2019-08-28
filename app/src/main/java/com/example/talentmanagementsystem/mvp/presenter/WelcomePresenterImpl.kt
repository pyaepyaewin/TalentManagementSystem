package com.example.talentmanagementsystem.mvp.presenter

import com.example.talentmanagementsystem.mvp.contract.WelcomeContract

class WelcomePresenterImpl:WelcomeContract.WelcomePresenter {
    private lateinit var welcomeView:WelcomeContract.WelcomeView
    override fun attachView(view: WelcomeContract.WelcomeView) {
        this.welcomeView=view
    }
}