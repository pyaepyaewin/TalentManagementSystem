package com.example.talentmanagementsystem.mvp.presenter

import android.util.Log
import com.example.talentmanagementsystem.data.models.PinCodeModel
import com.example.talentmanagementsystem.data.models.SharedPreference
import com.example.talentmanagementsystem.mvp.contract.PinCodeContract

class PinCodePresenterImpl : PinCodeContract.PinCodePresenter {
    private lateinit var pinCodeView: PinCodeContract.PinCodeView
    override fun attachView(view: PinCodeContract.PinCodeView) {
        this.pinCodeView = view
    }
    private val pinCodeModel: PinCodeModel by lazy {
        PinCodeModel.getInstance()
    }
    override fun loadPin(pin: Int) {
        pinCodeModel.sendPinCode(pin,
            {
                pinCodeView.pinCodeSuccess(it.data)

            },
            {
                pinCodeView.pinCodeFail(it.localizedMessage)
            })
    }

}

