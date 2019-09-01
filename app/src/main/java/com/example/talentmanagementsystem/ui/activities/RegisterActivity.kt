package com.example.talentmanagementsystem.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.WindowManager
import android.widget.*
import com.example.talentmanagementsystem.R
import com.example.talentmanagementsystem.mvp.contract.RegisterContract
import com.example.talentmanagementsystem.mvp.presenter.RegisterPresenterImpl
import com.example.talentmanagementsystem.ui.adapter.adapters.SpinnerAdapter1
import kotlinx.android.synthetic.main.activity_register.*
import kotlin.collections.ArrayList


class RegisterActivity : AppCompatActivity(), RegisterContract.RegisterView {


    companion object {
         var key : Int = 0
        var list = ArrayList<String>()
    }

    private val registerPresenter: RegisterContract.RegisterPresenter by lazy {
        RegisterPresenterImpl()

    }

    override fun registerFail(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()

    }

    //    override fun goToLoginPage() {
//        intent = Intent(this, LoginActivity::class.java)
//        startActivity(intent)
//    }
    override fun registerSuccess(message: String) {
        intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.example.talentmanagementsystem.R.layout.activity_register)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        registerPresenter.attachView(this)
        list = intent.getSerializableExtra(PinCodeActivity.EXTRA_STRING) as ArrayList<String>
        btnRegister.setOnClickListener {

            var name = edtName.text.toString()
            var email = edtEmail1.text.toString()
            var password = edtPassword1.text.toString()
            var confirmPassword = edtConfirmPassword.text.toString()
            var phone = edtPhone.text.toString()
            var dob = edtDob.text.toString()

            var address = edtAddress.text.toString()
            var module_id = key
            registerPresenter.loadRegisterData(name, email, password, confirmPassword, phone, dob, module_id, address)
        }

        val trackList = mutableListOf<String>()
        Log.d("tttttt", trackList.toString())
        trackList.addAll(list)
        var trackAdapter = SpinnerAdapter1(this, R.layout.spinner)
        trackAdapter.setTrackList(trackList)
        spinner.adapter = trackAdapter
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(p0: AdapterView<*>?) {

            }

            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                key = p2
                //Toast.makeText(this@RegisterActivity, trackList[p2], Toast.LENGTH_SHORT).show()

            }

        }


    }
}
