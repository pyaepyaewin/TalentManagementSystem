package com.example.talentmanagementsystem.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.talentmanagementsystem.R
import com.example.talentmanagementsystem.database.ScheduleDataClass
import com.example.talentmanagementsystem.mvp.contract.ScheduleContract
import com.example.talentmanagementsystem.mvp.presenter.SchedulePresenterImpl
import com.example.talentmanagementsystem.ui.adapter.displayer.Assignment.ItemDisplayer
import com.example.talentmanagementsystem.ui.adapter.adapters.ScheduleDelegateAdapter
import kotlinx.android.synthetic.main.activity_schedule.*

class ScheduleActivity : AppCompatActivity(),ScheduleContract.ScheduleView {
    private val mAdapter: ScheduleDelegateAdapter =
        ScheduleDelegateAdapter()
    private val mPresenter:ScheduleContract.SchedulePresenter by lazy {
       SchedulePresenterImpl(this)
    }
    override fun showScheduleList(displayerList: MutableList<ItemDisplayer>) {
mAdapter.setData(displayerList)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_schedule)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        arrow.setOnClickListener {
            onBackPressed()
            true
        }
        var schedule1=ScheduleDataClass("10am-12pm","Normalization","Tr Chaw Chaw Lay","Duration 1:00")
        var schedule2=ScheduleDataClass("1pm-4pm","PHP refactor","Tr Hla Hla Lay","Duration 3:00")
        var schedule3=ScheduleDataClass("10am-12pm","Database basic","Tr Chaw Chaw Lay","Duration 1:00")

        var todaySchedule= mutableListOf<ScheduleDataClass>(schedule1,schedule2,schedule3)
        rvSchedule.layoutManager= LinearLayoutManager(applicationContext)
        rvSchedule.adapter=mAdapter

        mPresenter.loadScheduleList()

    }
}
