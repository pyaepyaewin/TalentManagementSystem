package com.example.talentmanagementsystem.ui.adapter.viewholder

import android.util.Log
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.talentmanagementsystem.network_response.Teacher.Data
import kotlinx.android.synthetic.main.teacher.view.*

class TeacherViewHolder( private val view: View,
                         private val onClick: (data: Data) -> Unit
) : RecyclerView.ViewHolder(view) {
    fun setData(data: Data) {
        view.apply {
            teacherName.text = data.name
            position.text=data.position

            Log.d("teacher",data.position)
           // Picasso.get().load(data.photo).into(view.image)
            setOnClickListener {
                onClick(data)

            }
        }
    }
}