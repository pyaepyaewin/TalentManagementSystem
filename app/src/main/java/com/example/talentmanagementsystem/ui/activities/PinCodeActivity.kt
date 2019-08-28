package com.example.talentmanagementsystem.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.talentmanagementsystem.mvp.contract.PinCodeContract
import com.example.talentmanagementsystem.mvp.presenter.PinCodePresenterImpl
import com.example.talentmanagementsystem.network_response.PinCode.Data
import kotlinx.android.synthetic.main.activity_pin_code.*
import androidx.core.app.ComponentActivity
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.util.Log


class PinCodeActivity : AppCompatActivity(), PinCodeContract.PinCodeView {
    companion object {
        const val EXTRA_STRING = "string"
    }

    private val pinCodePresenter: PinCodeContract.PinCodePresenter by lazy { PinCodePresenterImpl() }
    override fun goToRegisterPage() {
        intent = Intent(this, RegisterActivity::class.java)
        startActivity(intent)
    }

    override fun pinCodeFail(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun pinCodeSuccess(user: List<Data>) {
        val myList = ArrayList<String>()

        for (list in user) {
            myList.add(list.name)
        }
        Log.d("Success*************", myList[0])

        intent = Intent(this, RegisterActivity::class.java)
        intent.putExtra(EXTRA_STRING, myList)
        startActivity(intent)

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.example.talentmanagementsystem.R.layout.activity_pin_code)
        pinCodePresenter.attachView(this)
        btnSave.setOnClickListener {
            var pin = edtCode.text.toString()
            pinCodePresenter.loadPin(pin.toInt())

        }
    }
}

