package com.example.talentmanagementsystem.ui.adapter.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.talentmanagementsystem.database.FeedbackDataClass
import com.example.talentmanagementsystem.ui.adapter.viewholder.FeedbackViewHolder

class FeedbackAdapter(var context: Context, var layout:Int, var list: List<FeedbackDataClass>):
    RecyclerView.Adapter<FeedbackViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeedbackViewHolder {
        var inflater = LayoutInflater.from(context)
        var view = inflater.inflate(layout, parent, false)
        return FeedbackViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.count()
    }

    override fun onBindViewHolder(holder: FeedbackViewHolder, position: Int) {
        holder.issueName.text = list[position].issueName
        holder.commenter.text = list[position].commenter
        holder.issue.text = list[position].issue
        holder.date.text = list[position].date

//        holder.itemView.setOnClickListener {
//            context.startActivity(ActivitiesDetailActivity.newIntent(context,list[position].chairmanName,
//                list[position].backgroundImage,list[position].bodyText))
//    }
    }
}