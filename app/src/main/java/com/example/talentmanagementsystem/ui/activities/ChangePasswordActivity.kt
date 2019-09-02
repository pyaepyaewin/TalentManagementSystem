package com.example.talentmanagementsystem.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.WindowManager
import android.widget.Toast
import com.example.talentmanagementsystem.R
import com.example.talentmanagementsystem.data.models.SharedPreference
import com.example.talentmanagementsystem.mvp.contract.ChangePasswordContract
import com.example.talentmanagementsystem.mvp.presenter.ChangePasswordPresenterImpl

import kotlinx.android.synthetic.main.activity_change_password.*

class ChangePasswordActivity : AppCompatActivity(), ChangePasswordContract.ChangePasswordView {


    private val changePasswordPresenter: ChangePasswordContract.ChangePasswordPresenter by lazy {
        ChangePasswordPresenterImpl(this)
    }

    override fun ChangePasswordSuccess(success: String) {
        Toast.makeText(this, "Changed Success", Toast.LENGTH_SHORT).show()
        val intent = ProfileActivity.newIntent(this)
        startActivity(intent)
    }

    override fun ChangedFail(message: String) {
        Toast.makeText(this, "Fail", Toast.LENGTH_SHORT).show()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_change_password)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        changePasswordPresenter.attachView(this)
        btnSave.setOnClickListener {

            var oldPasw = oldPasw.text.toString()
            var newPasw = newPasw.text.toString()
            var confirmPasw = confirmPasw.text.toString()
            Log.d("oldpassword", oldPasw)

            changePasswordPresenter.sendPassword(oldPasw, newPasw, confirmPasw)



        }
        arrow.setOnClickListener {
            onBackPressed()
            true
        }
    }
}
