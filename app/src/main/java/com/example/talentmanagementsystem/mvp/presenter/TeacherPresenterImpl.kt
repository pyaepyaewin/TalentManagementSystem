package com.example.talentmanagementsystem.mvp.presenter

import android.content.Context
import com.example.talentmanagementsystem.data.models.SharedPreference
import com.example.talentmanagementsystem.data.models.TeacherModel
import com.example.talentmanagementsystem.mvp.contract.TeacherContract

class TeacherPresenterImpl(val context: Context) : TeacherContract.TeacherPresenter {

    private lateinit var teacherView: TeacherContract.TeacherView
    override fun attachView(view: TeacherContract.TeacherView) {
        this.teacherView = view
    }

    private val teacherModel: TeacherModel by lazy {
        TeacherModel.getInstance()
    }

    override fun loadTeacherData(id: Int) {
        val token = SharedPreference.getInstance(context).getToken()
        teacherModel.loadTeacherData(id, {
            teacherView.showTeacherList(it.data)

        },
            {
                teacherView.error(it.localizedMessage)
            },
                "Bearer $token"
            )
    }


}