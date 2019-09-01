package com.example.talentmanagementsystem.mvp.contract

import com.example.talentmanagementsystem.database.ScheduleDataClass
import com.example.talentmanagementsystem.ui.adapter.displayer.Assignment.ItemDisplayer

interface ScheduleContract {
    interface ScheduleView{
        fun showScheduleList(scheduleList:List<ScheduleDataClass>)
    }

    interface SchedulePresenter{
        fun attachView(view: ScheduleView)
        fun loadScheduleList()
    }
}
