package com.example.talentmanagementsystem.ui.adapter.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.feedback.view.*

class FeedbackViewHolder(itemView:View): RecyclerView.ViewHolder(itemView){
    var issueName=itemView.feedbackTitle
    var commenter=itemView.commenter
    var issue=itemView.issue
    var date=itemView.date
}