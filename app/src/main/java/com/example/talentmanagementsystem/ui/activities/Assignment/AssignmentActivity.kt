package com.example.talentmanagementsystem.ui.activities.Assignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.talentmanagementsystem.R
import com.example.talentmanagementsystem.database.AssignmentDataClass
import com.example.talentmanagementsystem.mvp.contract.AssignmentContract
import com.example.talentmanagementsystem.mvp.presenter.AssignmentPresenterImpl
import com.example.talentmanagementsystem.network_response.AssignmentResponse.Complete

import com.example.talentmanagementsystem.network_response.AssignmentResponse.Data
import com.example.talentmanagementsystem.network_response.AssignmentResponse.StudentAssignment
import com.example.talentmanagementsystem.ui.activities.Activity.DetailActivitiesActivity
import com.example.talentmanagementsystem.ui.adapter.adapters.DelegateAdapter
//import com.example.talentmanagementsystem.ui.adapter.adapters.DelegateAdapter
import com.example.talentmanagementsystem.ui.adapter.displayer.Assignment.ItemDisplayer

import kotlinx.android.synthetic.main.activity_assignment.*

class AssignmentActivity : AppCompatActivity(),AssignmentContract.AssignmentView


{


    private lateinit var assignmentList: List<Data>
    private val mAdapter: DelegateAdapter =
        DelegateAdapter()
    private val mPresenter: AssignmentContract.AssignmentPresenter by lazy {
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
        rvAssignment.layoutManager = LinearLayoutManager(applicationContext)
        rvAssignment.adapter = mAdapter

        mPresenter.attachView(this)
        mPresenter.loadAssignmentList()

    }

    override fun showAssignmentList(displayerList: MutableList<ItemDisplayer>) {
        mAdapter.setData(displayerList)
    }

    override fun showDetailAssignmentList(data: Complete) {
        val assignmentIntent=
            AssignmentDetailActivity.newIntent(this,data.topic,data.student_assignments[0].mark)
        startActivity(assignmentIntent)
    }


}
