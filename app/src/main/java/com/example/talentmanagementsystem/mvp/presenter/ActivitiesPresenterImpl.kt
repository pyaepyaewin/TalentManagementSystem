package com.example.talentmanagementsystem.mvp.presenter

import android.content.Context
import com.example.talentmanagementsystem.data.models.ActivityModel
import com.example.talentmanagementsystem.data.models.SharedPreference
import com.example.talentmanagementsystem.mvp.contract.ActivitiesContract
import com.example.talentmanagementsystem.mvp.contract.AssignmentContract

class ActivitiesPresenterImpl(val context: Context):ActivitiesContract.ActivitiesPresenter {


    private lateinit var mView: ActivitiesContract.ActivitiesView


    private val activityModel: ActivityModel by lazy {
        ActivityModel().getInstance()
    }

    override fun attachView(view: ActivitiesContract.ActivitiesView) {
        this.mView = view
    }

    override fun loadActivities() {
        val token = SharedPreference.getInstance(context).getToken()
        activityModel.loadActivityData(
            {
                mView.showActivityList(it.data)
            },
            {
                mView.showError(it.localizedMessage)
            },
            "Bearer $token")
    }

}




