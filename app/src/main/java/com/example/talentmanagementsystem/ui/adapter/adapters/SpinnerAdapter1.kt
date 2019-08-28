package com.example.talentmanagementsystem.ui.adapter.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.talentmanagementsystem.R
import com.example.talentmanagementsystem.network_response.PinCode.Data
import com.example.talentmanagementsystem.ui.adapter.viewholder.SpinnerViewHolder
import kotlinx.android.synthetic.main.activity_register.view.*
import kotlinx.android.synthetic.main.spinner.view.*

class SpinnerAdapter1(var context:Context,var layout:Int) : BaseAdapter() {


    private var trackList = emptyList<String>()
    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        var inflater=LayoutInflater.from(context)
        var view=inflater.inflate(layout,p2,false)
        view.txtSpinner.text=trackList[p0]
        return view
    }

    override fun getItem(p0: Int): Any {
        return trackList[p0]
    }

    override fun getItemId(p0: Int): Long {
        return 0
    }

    override fun getCount(): Int {
        return trackList.count()
    }


    fun setTrackList(list : List<String>)
    {
        this.trackList = list
        notifyDataSetChanged()
    }
}