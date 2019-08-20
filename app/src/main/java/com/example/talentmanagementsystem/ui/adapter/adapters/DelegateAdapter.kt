package com.example.talentmanagementsystem.ui.adapter.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.talentmanagementsystem.ui.adapter.displayer.Assignment.ItemDisplayer
import com.example.talentmanagementsystem.ui.adapter.displayer.Assignment.ViewType
import com.example.talentmanagementsystem.ui.adapter.viewholder.AssignmentViewHolder

class DelegateAdapter: RecyclerView.Adapter<AssignmentViewHolder>()
{
    override fun getItemViewType(position: Int): Int = items[position].getViewType().ordinal

    var items = mutableListOf<ItemDisplayer>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AssignmentViewHolder =
        AssignmentViewHolder(LayoutInflater.from(parent.context).inflate(
            ViewType.values()[viewType].layoutId,
            parent, false))

    override fun getItemCount(): Int =items.size

    override fun onBindViewHolder(holder: AssignmentViewHolder, position: Int) =items[position].bind(holder.itemView)
    fun setData(items:MutableList<ItemDisplayer>) {
        this.items = items
        notifyDataSetChanged()

    }

}