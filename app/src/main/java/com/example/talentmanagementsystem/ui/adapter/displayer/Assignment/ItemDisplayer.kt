package com.example.talentmanagementsystem.ui.adapter.displayer.Assignment

import android.view.View
import com.example.talentmanagementsystem.ui.adapter.displayer.Assignment.ViewType

interface ItemDisplayer {
    fun getViewType(): ViewType
    fun bind(itemView: View)

}
