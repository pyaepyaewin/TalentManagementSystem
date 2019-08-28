package com.example.talentmanagementsystem.ui.adapter.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.spinner.view.*

class SpinnerViewHolder(private val view:View) :RecyclerView.ViewHolder(view){
    fun setData(track: String)
    {
        view.apply {
            txtSpinner.text= track
        }
    }
}