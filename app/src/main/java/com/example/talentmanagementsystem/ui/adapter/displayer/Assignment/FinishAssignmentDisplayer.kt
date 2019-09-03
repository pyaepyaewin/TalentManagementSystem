package com.example.talentmanagementsystem.ui.adapter.displayer.Assignment

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.View
import androidx.core.content.ContextCompat.startActivity
import com.example.talentmanagementsystem.network_response.AssignmentResponse.Complete
import com.example.talentmanagementsystem.network_response.AssignmentResponse.StudentAssignment
import com.example.talentmanagementsystem.ui.activities.Assignment.AssignmentDetailActivity
import kotlinx.android.synthetic.main.finishedassignment.view.*

class FinishAssignmentDisplayer(val context: Context,val data: Complete,val onClick:(data:Complete)->Unit): ItemDisplayer {

    override fun bind(itemView: View) {
        itemView.assignmentTitle.text = data.topic
        itemView.date.text = data.due_date
        itemView.setOnClickListener {
            onClick(data)
        }
    }
    override fun getViewType(): ViewType = ViewType.FINISH

}