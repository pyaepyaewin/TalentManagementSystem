package com.example.talentmanagementsystem.mvp.contract

interface CreateFeedbackContract {
    interface CreateFeedbackView
    {

    }
    interface CreateFeedbackPresenter
    {
        fun attachView(view:CreateFeedbackView)
    }
}