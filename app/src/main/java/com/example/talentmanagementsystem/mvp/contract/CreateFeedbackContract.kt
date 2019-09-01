package com.example.talentmanagementsystem.mvp.contract

interface CreateFeedbackContract {
    interface CreateFeedbackView {
        fun feedbackSuccess(message: String)
        fun feedbackFail(error: String)
    }

    interface CreateFeedbackPresenter {
        fun attachView(view: CreateFeedbackView)
        fun sendFeedBack(student_id: Int, title: String, description: String)
    }
}