package com.example.talentmanagementsystem.mvp.contract

import com.example.talentmanagementsystem.ui.adapter.displayer.Assignment.ItemDisplayer

interface ScheduleContract {
    interface ScheduleView{
        fun showScheduleList(displayerList:MutableList<ItemDisplayer>)
    }

    interface SchedulePresenter{
        fun attachView(view: ScheduleView)
        fun loadScheduleList()
    }
}
