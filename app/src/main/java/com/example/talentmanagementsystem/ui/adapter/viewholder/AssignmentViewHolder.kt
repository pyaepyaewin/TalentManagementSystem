package com.example.talentmanagementsystem.ui.adapter.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.talentmanagementsystem.network_response.AssignmentResponse.Complete
import kotlinx.android.synthetic.main.finishedassignment.view.*

class AssignmentViewHolder(
    private val view: View,
    private val onClickItem: (ass: Complete) -> Unit
) : RecyclerView.ViewHolder(view) {
    fun setData(ass: Complete) {
        view.apply {
            assignmentTitle.text = ass.topic
            /* time.text = data.activity_date
            Picasso.get().load(data.image).into(view.image)*/
            setOnClickListener {
                onClickItem(ass)
            }
        }

    }
}