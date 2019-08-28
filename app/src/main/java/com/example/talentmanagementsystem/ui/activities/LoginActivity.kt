package com.example.talentmanagementsystem.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import com.example.talentmanagementsystem.R
import com.example.talentmanagementsystem.data.models.LoginModel
import com.example.talentmanagementsystem.data.models.SharedPreference
import com.example.talentmanagementsystem.mvp.contract.LoginContract
import com.example.talentmanagementsystem.mvp.presenter.LoginPresenterImpl
import com.example.talentmanagementsystem.network_response.Login.Data
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(), LoginContract.LoginView {
    private val loginPresenter: LoginContract.LoginPresenter by lazy {
        LoginPresenterImpl(this)
    }

    override fun goToPinCodePage() {
        intent = Intent(this, PinCodeActivity::class.java)
        startActivity(intent)
    }

    override fun goToMainPage() {
        startActivity(MainActivity.newIntent(this))
    }


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        loginPresenter.attachView(this)
        val preference = SharedPreference.getInstance(this)
        btnRegister.setOnClickListener {
            goToPinCodePage()
        }
        btnLogin.setOnClickListener {

            var email = edtEmail.text.toString()
            var password = edtPassword.text.toString()
            loginPresenter.loadLogin(email, password)
            preference.isLogin("first")
            preference.setIsLogin("first", true)
        }


    }

    override fun loginSuccess(user: Data) {
        intent = Intent(this, MainActivity::class.java)
        startActivity(intent)

    }

    override fun loginFail(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

}



