package com.example.talentmanagementsystem.ui.adapter.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.talentmanagementsystem.R
import com.example.talentmanagementsystem.database.TeacherDataClass
import com.example.talentmanagementsystem.network_response.Teacher.Data
import com.example.talentmanagementsystem.ui.adapter.viewholder.TeacherViewHolder

class TeacherAdapter(private val onClick:(notice: Data)->Unit):
RecyclerView.Adapter<TeacherViewHolder>() {
    private var teacherDataList = emptyList<Data>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeacherViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.teacher, parent, false)
        return TeacherViewHolder(view = view, onClick = onClick)
    }

    override fun getItemCount(): Int {
        return teacherDataList.size
    }

    override fun onBindViewHolder(holder: TeacherViewHolder, position: Int) {
        holder.setData(teacherDataList[position])
    }

    fun setNewList(teacherList: List<Data>) {
        this.teacherDataList = teacherList
        notifyDataSetChanged()
    }
}
