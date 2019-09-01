package com.example.talentmanagementsystem.ui.adapter.displayer.Assignment

import android.view.View

interface ItemDisplayer
{
    fun getViewType():ViewType
    fun bind(itemView:View)
}
