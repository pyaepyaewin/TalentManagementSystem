package com.example.talentmanagementsystem.ui.activities.Teacher

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.talentmanagementsystem.R
import com.example.talentmanagementsystem.data.models.SharedPreference
import com.example.talentmanagementsystem.database.TeacherDataClass
import com.example.talentmanagementsystem.mvp.contract.TeacherContract
import com.example.talentmanagementsystem.mvp.presenter.TeacherPresenterImpl
import com.example.talentmanagementsystem.network_response.Teacher.Data
import com.example.talentmanagementsystem.ui.adapter.adapters.TeacherAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_teacher.*

class TeacherActivity : AppCompatActivity(), TeacherContract.TeacherView {
    private lateinit var teacherList: List<Data>
    private val mAdapter: TeacherAdapter by lazy {
        TeacherAdapter(this::onClickNoticeListItem)
    }
    private val mPresenter: TeacherContract.TeacherPresenter by lazy {
        TeacherPresenterImpl(this)
    }

    override fun showTeacherList(teacherList: List<Data>) {

        this.mAdapter.setNewList(teacherList)
    }

    override fun error(error: String) {
        Toast.makeText(applicationContext, error, Toast.LENGTH_SHORT).show()
    }

    private fun onClickNoticeListItem(data: Data) {
        Toast.makeText(applicationContext, "You clicked at ${data.name}", Toast.LENGTH_SHORT).show()
        intent = TeacherDetailActivity.newIntent(this, data)
        startActivity(intent)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_teacher)
        mPresenter.attachView(this)
        arrow.setOnClickListener {
            onBackPressed()
            true

        }
        rvTeacher.apply {
            layoutManager = LinearLayoutManager(applicationContext)
            adapter = mAdapter
        }
            mPresenter.loadTeacherData()


    }
}
