package com.example.talentmanagementsystem.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.talentmanagementsystem.R
import kotlinx.android.synthetic.main.activity_change_password.*

class ChangePasswordActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_change_password)
        arrow.setOnClickListener {
            onBackPressed()
            true
        }
    }
}
