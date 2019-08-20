package com.example.talentmanagementsystem.data.models

import com.example.talentmanagementsystem.ui.adapter.displayer.Assignment.ItemDisplayer
import com.example.talentmanagementsystem.ui.adapter.displayer.Schedule.ScheduleDisplayer
import com.example.talentmanagementsystem.ui.adapter.displayer.Schedule.ScheduleTitleDisplayer

class ScheduleModel:BaseModel() {
    fun loadScheduleList(success:(data:MutableList<ItemDisplayer>)->Unit, error:(String)->Unit){
        var mItemList = mutableListOf<ItemDisplayer>()

        mItemList.add(ScheduleTitleDisplayer("TODAY"))
        //val currentDataList = response.current
        //foreach(currentDataLIst){
        // mItemList.add(CurrentAssignmentDisplayer())
        //}
        mItemList.add((ScheduleDisplayer()))
        mItemList.add(ScheduleTitleDisplayer("JUNE 16"))
        mItemList.add(ScheduleDisplayer())


        mItemList.add(ScheduleDisplayer())



        success(mItemList)
    }
}
