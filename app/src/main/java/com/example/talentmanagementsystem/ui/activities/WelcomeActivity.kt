package com.example.talentmanagementsystem.ui.activities

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.talentmanagementsystem.R
import com.example.talentmanagementsystem.data.models.SharedPreference
import com.example.talentmanagementsystem.mvp.contract.WelcomeContract
import com.example.talentmanagementsystem.mvp.presenter.WelcomePresenterImpl
import kotlinx.android.synthetic.main.activity_welcome.*

class WelcomeActivity : AppCompatActivity(),WelcomeContract.WelcomeView {
    override fun goToLoginPage() {
        intent=Intent(this,LoginActivity::class.java)
        startActivity(intent)
    }

    private val mPresenter:WelcomeContract.WelcomePresenter by lazy { WelcomePresenterImpl() }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)
        mPresenter.attachView(this)
        btnStart.setOnClickListener {
            val previousLogin = SharedPreference.getInstance(this).isLogin("login")
            if (previousLogin){

                startActivity(Intent(this,MainActivity::class.java))
            } else{
                goToLoginPage()
            }

        }
    }


}
