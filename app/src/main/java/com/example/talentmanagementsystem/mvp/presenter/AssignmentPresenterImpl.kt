package com.example.talentmanagementsystem.mvp.presenter

import android.content.Context
import com.example.talentmanagementsystem.data.models.AssignmentModel
import com.example.talentmanagementsystem.data.models.SharedPreference
import com.example.talentmanagementsystem.mvp.contract.AssignmentContract
import com.example.talentmanagementsystem.network_response.AssignmentResponse.Complete
import com.example.talentmanagementsystem.ui.adapter.displayer.Assignment.CurrentAssignmentDisplayer
import com.example.talentmanagementsystem.ui.adapter.displayer.Assignment.FinishAssignmentDisplayer
import com.example.talentmanagementsystem.ui.adapter.displayer.Assignment.ItemDisplayer
import com.example.talentmanagementsystem.ui.adapter.displayer.Assignment.TitleDisplayer

class AssignmentPresenterImpl(val context: Context):AssignmentContract.AssignmentPresenter {
    private lateinit var assignmentView: AssignmentContract.AssignmentView

    private val assignmentModel: AssignmentModel by lazy {
        AssignmentModel().getInstance()
    }

    override fun attachView(view: AssignmentContract.AssignmentView) {
        this.assignmentView = view
    }

    override fun loadAssignmentList() {
        val token = SharedPreference.getInstance(context).getToken()
        var id=SharedPreference.getInstance(context).getUserId()

        assignmentModel.loadAssignmentList(
        {
            var mItemList = mutableListOf<ItemDisplayer>()

            mItemList.add(TitleDisplayer("InComplete"))
            val currentDataList = it.data.incomplete
            for(data in currentDataList)
            {
                mItemList.add(CurrentAssignmentDisplayer(context,data))
            }

            mItemList.add(TitleDisplayer("Complete"))
            val finishDataList = it.data.complete
            for(data in finishDataList) {
                mItemList.add(FinishAssignmentDisplayer(context,data,this::onClickFinishAssignment))
            }
            assignmentView.showAssignmentList(mItemList)
        }
    ,{

        }
            ,"Bearer $token",id)
    }

    fun onClickFinishAssignment(data:Complete){
       assignmentView.showDetailAssignmentList(data)
    }
}