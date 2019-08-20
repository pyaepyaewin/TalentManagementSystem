package com.example.talentmanagementsystem.ui.adapter.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.talentmanagementsystem.R
import com.example.talentmanagementsystem.database.ActivitiesDataClass
import com.example.talentmanagementsystem.network_response.Activity.Data
import com.example.talentmanagementsystem.ui.activities.DetailActivitiesActivity
import com.example.talentmanagementsystem.ui.adapter.viewholder.ActivitiesViewHolder
import kotlinx.android.synthetic.main.activity_main.*

class ActivitiesAdapter(private val onClick:(notice:Data)->Unit):RecyclerView.Adapter<ActivitiesViewHolder>()

{

    private var activityDataList= emptyList<Data>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActivitiesViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.activity,parent,false)
        return ActivitiesViewHolder(view=view,onClick=onClick)
    }

    override fun getItemCount(): Int {
       return activityDataList.size
    }

    override fun onBindViewHolder(holder: ActivitiesViewHolder, position: Int) {
        holder.setData(activityDataList[position])
    }
    fun setNewList(activityList:List<Data>)
    {
        this.activityDataList=activityList
        notifyDataSetChanged()
    }


}