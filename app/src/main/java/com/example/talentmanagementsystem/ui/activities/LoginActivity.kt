package com.example.talentmanagementsystem.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.talentmanagementsystem.R
import com.example.talentmanagementsystem.mvp.contract.LoginContract
import com.example.talentmanagementsystem.mvp.presenter.LoginPresenterImpl
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(), LoginContract.LoginView {
    override fun goToRegisterPage() {

        intent = Intent(this, RegisterActivity::class.java)
        startActivity(intent)


    }

    override fun showError(error: String) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show()
    }

    override fun goToMainPage() {
        startActivity(MainActivity.newIntent(this))
    }

    private val loginPresenter: LoginContract.LoginPresenter by lazy {
        LoginPresenterImpl()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        loginPresenter.attachView(this)

        btnLogin.setOnClickListener {
            loginPresenter.checkValidate(edtEmail.text.toString(), edtPassword.text.toString())
        }
        btnRegister.setOnClickListener{
goToRegisterPage()
        }

    }

}
