package com.example.talentmanagementsystem.data.models

import com.example.talentmanagementsystem.ui.adapter.displayer.Assignment.CurrentAssignmentDisplayer
import com.example.talentmanagementsystem.ui.adapter.displayer.Assignment.FinishAssignmentDisplayer
import com.example.talentmanagementsystem.ui.adapter.displayer.Assignment.ItemDisplayer
import com.example.talentmanagementsystem.ui.adapter.displayer.Assignment.TitleDisplayer

class AssignmentModel: BaseModel() {

    fun loadAssignmentList(success:(data:MutableList<ItemDisplayer>)->Unit, error:(String)->Unit){
        var mItemList = mutableListOf<ItemDisplayer>()

        mItemList.add(TitleDisplayer("Current"))
        //val currentDataList = response.current
        //foreach(currentDataLIst){
        // mItemList.add(CurrentAssignmentDisplayer())
        //}
        mItemList.add(CurrentAssignmentDisplayer())
        mItemList.add(CurrentAssignmentDisplayer())
        mItemList.add(CurrentAssignmentDisplayer())

        mItemList.add(TitleDisplayer("Finished"))        //val finishDataList = response.finsh

        //val FinishDataList = response.Finish
        //foreach(FinishDataList){
        // mItemList.add(FinishAssignmentDisplayer())
        //}
        mItemList.add(FinishAssignmentDisplayer())
        mItemList.add(FinishAssignmentDisplayer())


        success(mItemList)
    }
}