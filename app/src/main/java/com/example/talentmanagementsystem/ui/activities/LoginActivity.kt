package com.example.talentmanagementsystem.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.WindowManager
import android.widget.Toast
import com.example.talentmanagementsystem.R
import com.example.talentmanagementsystem.data.models.SharedPreference
import com.example.talentmanagementsystem.mvp.contract.LoginContract
import com.example.talentmanagementsystem.mvp.presenter.LoginPresenterImpl
import com.example.talentmanagementsystem.network_response.Login.Batch
import com.example.talentmanagementsystem.network_response.Login.Data
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_login.btnRegister

class LoginActivity : AppCompatActivity(), LoginContract.LoginView {
    val preference = SharedPreference.getInstance(this)
    private val loginPresenter: LoginContract.LoginPresenter by lazy {
        LoginPresenterImpl(this)
    }

    override fun goToPinCodePage() {
        intent = Intent(this, PinCodeActivity::class.java)
        startActivity(intent)
    }
//
//    override fun goToMainPage() {
//        startActivity(MainActivity.newIntent(this))
//    }


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        loginPresenter.attachView(this)

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
//        intent = Intent(this, MainActivity::class.java)
//        intent.putExtra("Data",user)
//        startActivity(intentent)
        var userName =user.name
        Log.d("uername****",userName)
        var email = user.email
        var address = user.address
        var phone = user.phone
        var date = user.date_of_birth
        var password=edtPassword.text.toString()
       // var module = user.module
        var photo = user.photo
        var batch_no=user.batch.batch_no
        var module=user.module.name
        preference.saveUserName(userName)
        preference.saveEmail(email)
        preference.saveAddress(address)
        preference.savePhone(phone)
        preference.saveDate(date)
        preference.savePhoto(photo)
        preference.savePassword(password)
        preference.saveBatchNo(batch_no)
        preference.saveModuleName(module)

        val intent = MainActivity.newIntent(this)
        startActivity(intent)

    }

    override fun loginFail(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

}



