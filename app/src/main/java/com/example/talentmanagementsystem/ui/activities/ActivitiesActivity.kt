package com.example.talentmanagementsystem.ui.activities

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.talentmanagementsystem.R
import com.example.talentmanagementsystem.mvp.contract.ActivitiesContract
import com.example.talentmanagementsystem.mvp.presenter.ActivitiesPresenterImpl
import com.example.talentmanagementsystem.network_response.Activity.Data
import com.example.talentmanagementsystem.ui.adapter.adapters.ActivitiesAdapter
import kotlinx.android.synthetic.main.activity_activities.*

class ActivitiesActivity : AppCompatActivity() ,ActivitiesContract.ActivitiesView
 {
    private val mAdapter:ActivitiesAdapter by lazy {
        ActivitiesAdapter(this::onClickNoticeListItem)
    }
    private val mPresenter: ActivitiesContract.ActivitiesPresenter by lazy {
        ActivitiesPresenterImpl()
    }

    override fun showActivityList(activityList: List<Data>) {
        this.mAdapter.setNewList(activityList)
    }

    override fun showError(error: String) {
       Toast.makeText(applicationContext,error,Toast.LENGTH_SHORT).show()
    }
private fun onClickNoticeListItem(data: Data)
{
    Toast.makeText(applicationContext,"You clicked at ${data.title}",Toast.LENGTH_SHORT).show()
}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_activities)

      rvActivity.apply {
          layoutManager= LinearLayoutManager(applicationContext)
          adapter=mAdapter
      }
        mPresenter.attachView(this)
        mPresenter.loadActivityList()

        arrow.setOnClickListener {
            onBackPressed()
            true
        }
    }
}
