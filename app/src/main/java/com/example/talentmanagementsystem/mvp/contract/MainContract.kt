package com.example.talentmanagementsystem.mvp.contract

import com.example.talentmanagementsystem.network_response.Login.Data

interface MainContract {
    interface MainView
    {
        fun goToProfilePage()
        fun goToActivityPage()
        fun goToAssignmentPage()
        fun goToSchedulePage()
        fun goToFeedbackPage()
        fun goToTeacherPage()
        fun goToInfoPage()
    }
    interface MainPresenter
    {
        fun attachView(view:MainView)
    }
}