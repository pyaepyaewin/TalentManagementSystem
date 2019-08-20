package com.example.talentmanagementsystem.mvp.presenter

import com.example.talentmanagementsystem.mvp.contract.MainContract

class MainPresenterImpl:MainContract.MainPresenter {
    private lateinit var mainView:MainContract.MainView
    override fun attachView(view: MainContract.MainView) {
        this.mainView=view
    }
}