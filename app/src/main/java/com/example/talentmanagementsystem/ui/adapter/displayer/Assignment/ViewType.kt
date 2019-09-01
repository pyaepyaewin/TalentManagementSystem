package com.example.talentmanagementsystem.ui.adapter.displayer.Assignment

import androidx.annotation.LayoutRes
import com.example.talentmanagementsystem.R

enum class ViewType(@LayoutRes val layoutId:Int) {
    CURRENT(R.layout.currentassignment),
    FINISH(R.layout.finishedassignment),
    TITLE(R.layout.title),
    TODAY(R.layout.todayschedule)

}