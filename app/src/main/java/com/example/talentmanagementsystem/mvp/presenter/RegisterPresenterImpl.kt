package com.example.talentmanagementsystem.mvp.presenter

import com.example.talentmanagementsystem.data.models.RegisterModel
import com.example.talentmanagementsystem.data.models.SharedPreference
import com.example.talentmanagementsystem.mvp.contract.RegisterContract
import java.sql.Date

class RegisterPresenterImpl:RegisterContract.RegisterPresenter {


    private lateinit var registerView:RegisterContract.RegisterView
    override fun attachView(view: RegisterContract.RegisterView) {
        this.registerView=view
    }
    private val registerModel: RegisterModel by lazy {
       RegisterModel.getInstance()
    }


    override fun loadRegisterData(
        name: String,
        email: String,
        password: String,
        confirm_password: String,
        phone: String,
        date_of_birth:String,
        module_id:Int,
    address:String
    ) {
        registerModel.register(name,email,password,confirm_password,phone,date_of_birth,module_id,address,
            {

                    registerView.registerSuccess("Wait admin Verify")
            },

        {
registerView.registerFail(it.localizedMessage)
        })
    }



}
