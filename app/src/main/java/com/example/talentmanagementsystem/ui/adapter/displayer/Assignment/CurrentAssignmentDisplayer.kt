package com.example.talentmanagementsystem.ui.adapter.displayer.Assignment

import android.content.Context
import android.view.View
import com.example.talentmanagementsystem.network_response.AssignmentResponse.Incomplete
import com.example.talentmanagementsystem.network_response.AssignmentResponse.StudentAssignment
import com.example.talentmanagementsystem.ui.activities.Assignment.AssignmentDetailActivity
import kotlinx.android.synthetic.main.currentassignment.view.*


class CurrentAssignmentDisplayer(val context: Context,val data: Incomplete): ItemDisplayer {
    override fun bind(itemView: View) {
        itemView.assignmentTitle.text = data.topic
        itemView.tvDuedate.text = data.due_date
        itemView.setOnClickListener {
            goToDetailActivity(data)
        }

    }

    override fun getViewType(): ViewType = ViewType.CURRENT

    private fun goToDetailActivity(data : Incomplete){
        //context.startActivity(AssignmentDetailActivity.newIntent(context,data as StudentAssignment))
    }
}