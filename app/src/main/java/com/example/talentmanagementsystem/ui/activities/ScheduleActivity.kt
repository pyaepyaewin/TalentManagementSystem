package com.example.talentmanagementsystem.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.talentmanagementsystem.R
import com.example.talentmanagementsystem.database.ScheduleDataClass
import com.example.talentmanagementsystem.mvp.contract.ScheduleContract
import com.example.talentmanagementsystem.mvp.presenter.SchedulePresenterImpl
import com.example.talentmanagementsystem.ui.adapter.adapters.ScheduleDelegateAdapter
import com.example.talentmanagementsystem.ui.adapter.displayer.Assignment.ItemDisplayer
import kotlinx.android.synthetic.main.activity_schedule.*

class ScheduleActivity : AppCompatActivity() {

    // private var mItemList= mutableListOf<ItemDisplayer>()




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_schedule)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        arrow.setOnClickListener {
            onBackPressed()
            true
        }
        var schedule1 = ScheduleDataClass("10am-12pm", "Normalization", "Tr Chaw Chaw Lay", "duration 2:00")
       var schedule2 = ScheduleDataClass("1pm-4pm", "PHP refactor", "Tr Hla Hla Lay", "duration 3:00")
        var schedule3 = ScheduleDataClass("10am-12pm", "Database basic", "Tr Chaw Chaw Lay", "duration 2:00")

       var todaySchedule = mutableListOf<ScheduleDataClass>(schedule1, schedule2, schedule3)

        var adapter = ScheduleDelegateAdapter(this, R.layout.todayschedule, todaySchedule)
        rvSchedule.layoutManager= LinearLayoutManager(applicationContext)
        rvSchedule.adapter=adapter



    }
}
