package com.example.talentmanagementsystem.ui.adapter.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.talentmanagementsystem.network_response.FeedBack.GetFeedBack.Data
import kotlinx.android.synthetic.main.feedback.view.*

class FeedbackViewHolder( private val view: View)
: RecyclerView.ViewHolder(view) {
    fun setData(data: Data) {
        view.apply {
            feedbackTitle.text = data.title
            issue.text = data.description
          //date.text=data.created_at.toString()


        }
    }
}