package com.example.talentmanagementsystem.mvp.presenter

import android.content.Context
import com.example.talentmanagementsystem.R
import com.example.talentmanagementsystem.data.models.ScheduleModel
import com.example.talentmanagementsystem.database.ScheduleDataClass
import com.example.talentmanagementsystem.mvp.contract.ScheduleContract
import com.example.talentmanagementsystem.ui.adapter.adapters.ScheduleDelegateAdapter

class SchedulePresenterImpl(val context: Context, private var view:ScheduleContract.ScheduleView)
{
//ScheduleContract.SchedulePresenter {
//    private lateinit var scheduleView: ScheduleContract.ScheduleView
//    override fun attachView(view: ScheduleContract.ScheduleView) {
//        this.scheduleView = view
//    }
//
//    override fun loadScheduleList() {
//
//    }
}