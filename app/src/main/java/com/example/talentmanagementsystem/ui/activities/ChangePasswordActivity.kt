package com.example.talentmanagementsystem.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.Toast
import com.example.talentmanagementsystem.R
import com.example.talentmanagementsystem.data.models.SharedPreference
import com.example.talentmanagementsystem.mvp.contract.ChangePasswordContract
import com.example.talentmanagementsystem.mvp.presenter.ChangePasswordPresenterImpl

import kotlinx.android.synthetic.main.activity_change_password.*

class ChangePasswordActivity : AppCompatActivity(), ChangePasswordContract.ChangePasswordView {
    private val changePasswordPresenter: ChangePasswordContract.ChangePasswordPresenter by lazy {
        ChangePasswordPresenterImpl()
    }

    override fun ChangePasswordSuccess(success: String) {
        Toast.makeText(this, "Changed Success", Toast.LENGTH_SHORT).show()
    }

    override fun FailChanges(message: String) {
        Toast.makeText(this, "Changed Fail", Toast.LENGTH_SHORT).show()

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_change_password)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        changePasswordPresenter.attachView(this)
        btnSave.setOnClickListener {
            var student_id = SharedPreference.getInstance(this).getUserId()
            var oldPasw = oldPasw.text.toString()
            var newPasw = newPasw.text.toString()
            var confirmPasw = confirmPasw.text.toString()
            changePasswordPresenter.sendPassword(student_id, oldPasw, newPasw, confirmPasw)
        }
        arrow.setOnClickListener {
            onBackPressed()
            true
        }
    }
}
