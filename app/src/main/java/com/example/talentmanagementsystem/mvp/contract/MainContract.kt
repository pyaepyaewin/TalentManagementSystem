package com.example.talentmanagementsystem.mvp.contract

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