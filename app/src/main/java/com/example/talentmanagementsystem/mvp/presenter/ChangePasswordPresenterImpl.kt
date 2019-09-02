package com.example.talentmanagementsystem.mvp.presenter

import android.content.Context
import android.util.Log
import com.example.talentmanagementsystem.data.models.ChangePasswordModel
import com.example.talentmanagementsystem.data.models.SharedPreference
import com.example.talentmanagementsystem.mvp.contract.ChangePasswordContract

class ChangePasswordPresenterImpl(val context: Context) : ChangePasswordContract.ChangePasswordPresenter {


    private lateinit var changePasswordView: ChangePasswordContract.ChangePasswordView
    private val changePasswordModel: ChangePasswordModel by lazy {
        ChangePasswordModel.getInstance()
    }

    override fun attachView(view: ChangePasswordContract.ChangePasswordView) {
        this.changePasswordView = view
    }
    override fun sendPassword(old_password: String, new_password: String, confirm_password: String) {
        val token=SharedPreference.getInstance(context).getToken()
        val student_id=SharedPreference.getInstance(context).getUserId()
changePasswordModel.changePassword("Bearer $token",student_id,old_password,new_password,confirm_password,
    {

        Log.d("OK","send")
        changePasswordView.ChangePasswordSuccess("Successfully Changed Password")
    },
    {
        changePasswordView.ChangedFail("Changed Fail!!")
        Log.d("null","notsend")
    })
    }

    }



