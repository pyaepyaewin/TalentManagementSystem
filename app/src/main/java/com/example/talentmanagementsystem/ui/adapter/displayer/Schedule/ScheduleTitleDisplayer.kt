package com.example.talentmanagementsystem.ui.adapter.displayer.Schedule

import android.view.View
import com.example.talentmanagementsystem.ui.adapter.displayer.Assignment.ItemDisplayer
import com.example.talentmanagementsystem.ui.adapter.displayer.Assignment.ViewType
import kotlinx.android.synthetic.main.scheduletitle.view.*

class ScheduleTitleDisplayer(val title:String):ItemDisplayer{
    override fun getViewType(): ViewType =ViewType.TITLE
    override fun bind(itemView: View) {
        itemView.scheduleTitle.text=title
    }


}