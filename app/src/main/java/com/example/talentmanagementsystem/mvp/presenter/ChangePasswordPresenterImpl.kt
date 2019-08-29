package com.example.talentmanagementsystem.mvp.presenter

import com.example.talentmanagementsystem.data.models.ChangePasswordModel
import com.example.talentmanagementsystem.mvp.contract.ChangePasswordContract

class ChangePasswordPresenterImpl : ChangePasswordContract.ChangePasswordPresenter {
    private lateinit var changePasswordView: ChangePasswordContract.ChangePasswordView
    private val changePasswordModel: ChangePasswordModel by lazy {
        ChangePasswordModel.getInstance()
    }

    override fun attachView(view: ChangePasswordContract.ChangePasswordView) {
        this.changePasswordView = view
    }

    override fun sendPassword(student_id: Int, old_password: String, new_password: String, confirm_password: String) {
        changePasswordModel.changePassword(student_id, old_password, new_password, confirm_password, {
            if (it.code in 200..300) {
                changePasswordView.ChangePasswordSuccess("Changed Password Successfully")

            } else {
                changePasswordView.FailChanges("Changed Password Failed!!")
            }
        }, {
            changePasswordView.FailChanges("Changed Password Error!!!")
        })
    }

}

