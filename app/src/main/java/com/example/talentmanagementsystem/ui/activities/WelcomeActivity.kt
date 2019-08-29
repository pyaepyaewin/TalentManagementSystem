package com.example.talentmanagementsystem.ui.activities

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import com.example.talentmanagementsystem.R
import com.example.talentmanagementsystem.data.models.SharedPreference
import com.example.talentmanagementsystem.mvp.contract.WelcomeContract
import com.example.talentmanagementsystem.mvp.presenter.WelcomePresenterImpl
import kotlinx.android.synthetic.main.activity_welcome.*

class WelcomeActivity : AppCompatActivity(), WelcomeContract.WelcomeView {
    override fun goToLoginPage() {
        intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
    }

    private val mPresenter: WelcomeContract.WelcomePresenter by lazy { WelcomePresenterImpl() }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        mPresenter.attachView(this)
        btnStart.setOnClickListener {
            val previousLogin = SharedPreference.getInstance(this).isLogin("login")
            if (previousLogin) {
//                val name = SharedPreference.getInstance(this).getUserName()
//                var email = SharedPreference.getInstance(this).getEmail()
//                var address = SharedPreference.getInstance(this).getAddress()
//                var phone = SharedPreference.getInstance(this).getPhone()
//                var module_id = SharedPreference.getInstance(this).getModule()
//                var photo = SharedPreference.getInstance(this).getPhoto()
//                var dob = SharedPreference.getInstance(this).getDob()

                val mainIntent = MainActivity.newIntent(applicationContext)
                startActivity(mainIntent)
            } else {
                goToLoginPage()
            }

        }
    }


}
