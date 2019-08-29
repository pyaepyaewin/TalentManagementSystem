package com.example.talentmanagementsystem.ui.activities.Assignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.talentmanagementsystem.R
import com.example.talentmanagementsystem.database.AssignmentDataClass
import com.example.talentmanagementsystem.mvp.contract.AssignmentContract
import com.example.talentmanagementsystem.mvp.presenter.AssignmentPresenterImpl
import com.example.talentmanagementsystem.ui.adapter.adapters.DelegateAdapter
import com.example.talentmanagementsystem.ui.adapter.displayer.Assignment.ItemDisplayer
import kotlinx.android.synthetic.main.activity_assignment.*

class AssignmentActivity : AppCompatActivity(),AssignmentContract.AssignmentView {
    private val mAdapter: DelegateAdapter =
        DelegateAdapter()
    private val mPresenter:AssignmentContract.AssignmentPresenter by lazy {
        AssignmentPresenterImpl(this)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_assignment)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        arrow.setOnClickListener {
            onBackPressed()
            true
        }
        var assignment1=AssignmentDataClass(R.drawable.finish,"CSS Frame","Tr Kyant","Due Date June 2")
        var assignment2=AssignmentDataClass(R.drawable.error,"Final Design","Tr Kyaw","Due Date June1")
        var currentAssignment= mutableListOf<AssignmentDataClass>(assignment1,assignment2)
        rvAssignment.layoutManager= LinearLayoutManager(applicationContext)
        rvAssignment.adapter=mAdapter

        mPresenter.loadAssignmentList()

    }

    override fun showAssignmentList(displayerList: MutableList<ItemDisplayer>) {
        mAdapter.setData(displayerList)
    }
}
