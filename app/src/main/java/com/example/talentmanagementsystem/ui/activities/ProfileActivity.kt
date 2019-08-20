package com.example.talentmanagementsystem.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.talentmanagementsystem.R
import com.example.talentmanagementsystem.mvp.contract.ProfileContract
import com.example.talentmanagementsystem.mvp.presenter.ProfilePresenterImpl
import kotlinx.android.synthetic.main.activity_profile.*

class ProfileActivity : AppCompatActivity(),ProfileContract.ProfileView {
    override fun goToChangePasswordPage() {
        intent=Intent(this, ChangePasswordActivity::class.java)
        startActivity(intent)
    }

    private val profilePresenter:ProfileContract.ProfilePresenter by lazy {
        ProfilePresenterImpl()
    }
    override fun goToLoginPage() {
        intent= Intent(this, LoginActivity::class.java)
        startActivity(intent)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        profilePresenter.attachView(this)
        arrow.setOnClickListener {
            onBackPressed()
            true
        }
        btnLogout.setOnClickListener {
            goToLoginPage()
        }
        btnChangePsw.setOnClickListener {
            goToChangePasswordPage()
        }

    }
}
