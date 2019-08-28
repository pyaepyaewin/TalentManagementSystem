
package com.example.talentmanagementsystem.ui.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.talentmanagementsystem.R
import com.example.talentmanagementsystem.mvp.contract.ProfileContract
import com.example.talentmanagementsystem.mvp.presenter.ProfilePresenterImpl
import com.example.talentmanagementsystem.network_response.Login.Data
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_profile.*

class ProfileActivity : AppCompatActivity(),ProfileContract.ProfileView {
    companion object {
        var data : Data? = null
        fun newIntent(context: Context, data : Data): Intent {
            val intent = Intent(context, ProfileActivity::class.java)
            intent.putExtra("Data", data)
            return intent
        }
    }
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
        data= intent.getSerializableExtra("Data") as Data?
        track.text= data?.module_id.toString()
        dob.text= data?.date_of_birth
        email.text= data?.email
        phNum.text= data?.phone
        address.text= data?.address
        Picasso.get().load(data?.photo).into(userProfile)

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
