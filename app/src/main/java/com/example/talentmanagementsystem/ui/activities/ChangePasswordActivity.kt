package com.example.talentmanagementsystem.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.talentmanagementsystem.R
import com.example.talentmanagementsystem.mvp.contract.ChangePasswordContract
import com.example.talentmanagementsystem.mvp.presenter.ChangePasswordPresenterImpl
import com.example.talentmanagementsystem.ui.activities.ProfileActivity.Companion.data
import kotlinx.android.synthetic.main.activity_change_password.*

class ChangePasswordActivity : AppCompatActivity(),ChangePasswordContract.ChangePasswordView {
    private val changePasswordPresenter:ChangePasswordContract.ChangePasswordPresenter by lazy {
        ChangePasswordPresenterImpl()
    }
    override fun ChangePasswordSuccess(success: String) {

    }

    override fun FailChanges(message: String) {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_change_password)
        changePasswordPresenter.attachView(this)
        btnSave.setOnClickListener {
            var student_id=data?.id.toString()
            var oldPasw=oldPasw.text.toString()
            var newPasw=newPasw.text.toString()
            var confirmPasw=confirmPasw.text.toString()
            //changePasswordPresenter.sendPassword(student_id,oldPasw,newPasw,confirmPasw)
        }
        arrow.setOnClickListener {
            onBackPressed()
            true
        }
    }
}
