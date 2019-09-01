package com.example.talentmanagementsystem.mvp.contract

import com.example.talentmanagementsystem.network_response.Teacher.Data

interface TeacherContract {
    interface TeacherView
    {
       fun showTeacherList(teacherList:List<Data>)
        fun error(error:String)
    }
    interface TeacherPresenter
    {
        fun attachView(view: TeacherView)
        fun loadTeacherData()
    }
}