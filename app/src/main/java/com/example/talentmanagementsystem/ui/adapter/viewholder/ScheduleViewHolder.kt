package com.example.talentmanagementsystem.ui.adapter.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.todayschedule.view.*

class ScheduleViewHolder(v: View):RecyclerView.ViewHolder(v) {
    var time=v.time
    var course=v.course
    var teacherName=v.teacherName
    var duration=v.duration

}