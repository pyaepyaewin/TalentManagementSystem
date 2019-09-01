package com.example.talentmanagementsystem.mvp.contract

import com.example.talentmanagementsystem.network_response.FeedBack.GetFeedBack.Data
import com.example.talentmanagementsystem.network_response.FeedBack.GetFeedBack.FeedbackResponse

interface FeedbackContract {
    interface FeedbackView {
        fun goToCreateFeedbackPage()
        fun showFeedbackList(feedbackList:List<Data>)
        fun showError(error:String)
    }

    interface FeedbackPresenter {
        fun attachView(view: FeedbackView)
        fun loadFeedBacks()
    }
}