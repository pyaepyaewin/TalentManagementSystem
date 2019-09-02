
package com.example.talentmanagementsystem.ui.activities

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import com.bumptech.glide.Glide
import com.example.talentmanagementsystem.R
import com.example.talentmanagementsystem.data.models.SharedPreference
import com.example.talentmanagementsystem.mvp.contract.ProfileContract
import com.example.talentmanagementsystem.mvp.presenter.ProfilePresenterImpl
import kotlinx.android.synthetic.main.activity_profile.*

class ProfileActivity : AppCompatActivity(),ProfileContract.ProfileView {
    lateinit var thumb:Uri
    companion object {
        val REQUEST_IMAGE_CAPTURE = 1
        fun newIntent(context: Context): Intent {
            val intent = Intent(context, ProfileActivity::class.java)
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
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        profilePresenter.attachView(this)
        arrow.setOnClickListener {
            onBackPressed()
            true
        }
        track.text= SharedPreference.getInstance(this).getModuleName()
        batch.text=SharedPreference.getInstance(this).getBatchNo()
        dob.text=SharedPreference.getInstance(this).getDob()
        name.text= SharedPreference.getInstance(this).getUserName()
        email.text= SharedPreference.getInstance(this).getEmail()
        phNum.text=SharedPreference.getInstance(this).getPhone()
        address.text=SharedPreference.getInstance(this).getAddress()
        //Picasso.get().load(SharedPreference.getInstance(this).getPhoto()).into(userProfile)


        btnLogout.setOnClickListener {
            goToLoginPage()
            SharedPreference.getInstance(this).setIsLogin("login",false)
        }
        btnChangePsw.setOnClickListener {
            goToChangePasswordPage()
        }

        edit.setOnClickListener {

            val intent = Intent(Intent.ACTION_GET_CONTENT)

            intent.type = "image/*"

            if (intent.resolveActivity(packageManager) != null) {
                startActivityForResult(intent, REQUEST_IMAGE_CAPTURE)
            }
//            var profile=edit.setImageURI(thumb).toString()
       //    SharedPreference.getInstance(this).saveProfile()
        }

}
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        thumb= data!!.data!!
        Glide.with(this).load(thumb).into(profile)

    }

    }
