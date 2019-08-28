package com.example.talentmanagementsystem.mvp.presenter

import com.example.talentmanagementsystem.mvp.contract.FeedbackContract

class FeedbackPresenterImpl:FeedbackContract.FeedbackPresenter {
    private lateinit var feedbackView:FeedbackContract.FeedbackView
    override fun attachView(view: FeedbackContract.FeedbackView) {
        this.feedbackView=view
    }



}