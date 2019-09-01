package com.example.talentmanagementsystem.ui.adapter.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.talentmanagementsystem.R
import com.example.talentmanagementsystem.database.FeedbackDataClass
import com.example.talentmanagementsystem.network_response.FeedBack.GetFeedBack.Data
import com.example.talentmanagementsystem.ui.adapter.viewholder.FeedbackViewHolder

class FeedbackAdapter() : RecyclerView.Adapter<FeedbackViewHolder>() {
    private var feedbackList = emptyList<Data>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeedbackViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.feedback,parent,false)
        return FeedbackViewHolder(view)
    }

    override fun getItemCount(): Int {
        return feedbackList.size
    }

    override fun onBindViewHolder(holder: FeedbackViewHolder, position: Int) {

        holder.setData(feedbackList[position])
    }

    fun setNewList(feedbackData: List<Data>) {
        this.feedbackList = feedbackData
        notifyDataSetChanged()
    }
}