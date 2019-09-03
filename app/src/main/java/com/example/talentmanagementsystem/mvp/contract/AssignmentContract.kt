package com.example.talentmanagementsystem.mvp.contract

import com.example.talentmanagementsystem.network_response.AssignmentResponse.Complete
import com.example.talentmanagementsystem.ui.adapter.displayer.Assignment.ItemDisplayer

interface AssignmentContract {

    interface AssignmentView{
        fun showAssignmentList(displayerList:MutableList<ItemDisplayer>)
        fun showDetailAssignmentList(data:Complete)

    }

    interface AssignmentPresenter{
        fun attachView(view: AssignmentView)
        fun loadAssignmentList()
    }
}