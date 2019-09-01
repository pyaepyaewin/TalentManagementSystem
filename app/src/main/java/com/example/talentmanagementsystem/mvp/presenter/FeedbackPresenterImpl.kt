package com.example.talentmanagementsystem.mvp.presenter

import android.content.Context
import android.util.Log
import com.example.talentmanagementsystem.data.models.FeedBackModel
import com.example.talentmanagementsystem.data.models.SharedPreference
import com.example.talentmanagementsystem.mvp.contract.FeedbackContract

class FeedbackPresenterImpl (val context: Context): FeedbackContract.FeedbackPresenter {
    private lateinit var feedbackView: FeedbackContract.FeedbackView
    override fun attachView(view: FeedbackContract.FeedbackView) {
        this.feedbackView = view
    }

    private val feedbackModel: FeedBackModel by lazy {
        FeedBackModel.getInstance()
    }

    override fun loadFeedBacks() {
        Log.d("Do","Dooooooooooo")
        val token = SharedPreference.getInstance(context).getToken()
        feedbackModel.loadFeedBack(
            {
                feedbackView.showFeedbackList(it.data)
                Log.d("FeedBack","FeedBackLoad***")
            },
            {
                //
                Log.d("ErrorFeedback","FeedbackError!!!!")
            },
            "Bearer $token"
        )
    }

}