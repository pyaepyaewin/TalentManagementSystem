package com.example.talentmanagementsystem.ui.adapter.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.talentmanagementsystem.database.ScheduleDataClass
import com.example.talentmanagementsystem.ui.adapter.displayer.Assignment.ItemDisplayer
import com.example.talentmanagementsystem.ui.adapter.displayer.Assignment.ViewType
import com.example.talentmanagementsystem.ui.adapter.viewholder.ScheduleViewHolder

class ScheduleDelegateAdapter(var context: Context, var layout:Int, var list:List<ScheduleDataClass>): RecyclerView.Adapter<ScheduleViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScheduleViewHolder
    {
        var inflater=LayoutInflater.from(context)
        var view=inflater.inflate(layout,parent,false)
        return ScheduleViewHolder(view)
    }


    override fun getItemCount(): Int = list.count()

    override fun onBindViewHolder(holder: ScheduleViewHolder, position: Int)
    {
        holder.time.text=list[position].time
        holder.course.text=list[position].course
        holder.teacherName.text=list[position].teacherName
        holder.duration.text=list[position].duration
    }
        fun setData(items: MutableList<ScheduleDataClass>) {
            this.list = items
            notifyDataSetChanged()

    }
}