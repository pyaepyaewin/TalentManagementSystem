package com.example.talentmanagementsystem.ui.adapter.displayer.Schedule

import android.view.View
import com.example.talentmanagementsystem.ui.adapter.displayer.Assignment.ItemDisplayer
import com.example.talentmanagementsystem.ui.adapter.displayer.Assignment.ViewType

class ScheduleTitleDisplayer(val title:String): ItemDisplayer {
    override fun getViewType(): ViewType =ViewType.SCHEDULETITLE

    override fun bind(itemView: View) {

    }
}