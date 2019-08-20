package com.example.talentmanagementsystem.mvp.presenter

import com.example.talentmanagementsystem.data.models.AssignmentModel
import com.example.talentmanagementsystem.mvp.contract.AssignmentContract

class AssignmentPresenterImpl(private var view:AssignmentContract.AssignmentView):AssignmentContract.AssignmentPresenter {

    override fun attachView(view: AssignmentContract.AssignmentView) {
        this.view = view
    }

    override fun loadAssignmentList() {
        val mModel = AssignmentModel()
        mModel.loadAssignmentList({mItemList->
            view.showAssignmentList(mItemList)
        },{

        })
    }
}