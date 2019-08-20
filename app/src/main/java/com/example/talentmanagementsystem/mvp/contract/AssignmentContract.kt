package com.example.talentmanagementsystem.mvp.contract

import com.example.talentmanagementsystem.ui.adapter.displayer.Assignment.ItemDisplayer

interface AssignmentContract {

    interface AssignmentView{
        fun showAssignmentList(displayerList:MutableList<ItemDisplayer>)

    }

    interface AssignmentPresenter{
        fun attachView(view: AssignmentView)
        fun loadAssignmentList()
    }
}