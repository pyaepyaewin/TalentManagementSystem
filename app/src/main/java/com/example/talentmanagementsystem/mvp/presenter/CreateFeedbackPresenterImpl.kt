package com.example.talentmanagementsystem.mvp.presenter

import android.content.Context
import com.example.talentmanagementsystem.data.models.CreateFeedbackModel
import com.example.talentmanagementsystem.data.models.SharedPreference
import com.example.talentmanagementsystem.mvp.contract.CreateFeedbackContract

class CreateFeedbackPresenterImpl(val context: Context):CreateFeedbackContract.CreateFeedbackPresenter {
    private lateinit var createFeedBackView: CreateFeedbackContract.CreateFeedbackView
    private val createFeedbackModel: CreateFeedbackModel by lazy {
        CreateFeedbackModel.getInstance()
    }
    override fun attachView(view: CreateFeedbackContract.CreateFeedbackView) {
        this.createFeedBackView=view
    }

    override fun sendFeedBack(student_id: Int, title: String, description: String) {
        val token = SharedPreference.getInstance(context).getToken()

        createFeedbackModel.sendFeedBackData(student_id,title,description, {

                createFeedBackView.feedbackSuccess("Successfully Send!!")



        }, {
            createFeedBackView.feedbackFail(it.localizedMessage)
        },"Bearer $token")
    }

}
