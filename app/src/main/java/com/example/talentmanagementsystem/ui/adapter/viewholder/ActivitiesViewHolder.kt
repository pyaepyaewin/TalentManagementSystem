package com.example.talentmanagementsystem.ui.adapter.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.talentmanagementsystem.network_response.Activity.ActivityResponse
import com.example.talentmanagementsystem.network_response.Activity.Data
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity.view.*

class ActivitiesViewHolder(
    private val view: View,
    private val onClick: (data: Data) -> Unit
) : RecyclerView.ViewHolder(view) {
    fun setData(data: Data) {
        view.apply {
            title.text = data.title
            speaker.text = data.speaker
            time.text = data.activity_date
            Picasso.get().load(data.image).into(view.image)
            setOnClickListener {
            }
        }
    }
}