package com.example.talentmanagementsystem.ui.adapter.displayer.Assignment

import android.view.View
import kotlinx.android.synthetic.main.title.view.*

class TitleDisplayer(val title:String):
    ItemDisplayer {
    override fun getViewType(): ViewType =
        ViewType.TITLE



    override fun bind(itemView: View) {
        itemView.apply { article.text = title }
    }
}