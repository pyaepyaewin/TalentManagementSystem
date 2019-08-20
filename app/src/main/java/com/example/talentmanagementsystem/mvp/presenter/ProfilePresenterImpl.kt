package com.example.talentmanagementsystem.mvp.presenter

import com.example.talentmanagementsystem.mvp.contract.ProfileContract

class ProfilePresenterImpl:ProfileContract.ProfilePresenter {
    private lateinit var profileView:ProfileContract.ProfileView
    override fun attachView(view: ProfileContract.ProfileView) {
        this.profileView=view
    }
}