package com.example.talentmanagementsystem.mvp.contract

interface FeedbackContract {
    interface FeedbackView {
        fun goToCreateFeedbackPage()
    }

    interface FeedbackPresenter {
        fun attachView(view: FeedbackView)
    }
}