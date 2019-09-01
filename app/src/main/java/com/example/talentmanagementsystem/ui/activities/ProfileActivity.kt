
package com.example.talentmanagementsystem.ui.activities

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.WindowManager
import com.example.talentmanagementsystem.R
import com.example.talentmanagementsystem.data.models.SharedPreference
import com.example.talentmanagementsystem.mvp.contract.ProfileContract
import com.example.talentmanagementsystem.mvp.presenter.ProfilePresenterImpl
import com.example.talentmanagementsystem.network_response.Login.Data
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_profile.*

class ProfileActivity : AppCompatActivity(),ProfileContract.ProfileView {
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
        track.text= SharedPreference.getInstance(this).getModule()
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

    //val locationForPhotos: Uri
//
//    fun capturePhoto(targetFilename: String) {
//        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE).apply {
//            putExtra(MediaStore.EXTRA_OUTPUT, Uri.withAppendedPath(locationForPhotos, targetFilename))
//        }
//        if (intent.resolveActivity(packageManager) != null) {
//            startActivityForResult(intent, REQUEST_IMAGE_CAPTURE)
//        }
//    }
//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent) {
//        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == Activity.RESULT_OK) {
//            val thumbnail: Bitmap = data.getParcelableExtra("data")
//            // Do other work with full size photo saved in locationForPhotos
//            ...
//        }
//    }


}
}


    }
