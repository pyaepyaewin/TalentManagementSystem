package com.example.talentmanagementsystem.mvp.presenter

import com.example.talentmanagementsystem.data.models.ScheduleModel
import com.example.talentmanagementsystem.mvp.contract.ScheduleContract

class SchedulePresenterImpl(private var view:ScheduleContract.ScheduleView):ScheduleContract.SchedulePresenter {
    override fun attachView(view: ScheduleContract.ScheduleView) {
        this.view=view
    }

    override fun loadScheduleList() {
        val mModel = ScheduleModel()
        mModel.loadScheduleList({mItemList->
            view.showScheduleList(mItemList)
        },{

        })
    }
}