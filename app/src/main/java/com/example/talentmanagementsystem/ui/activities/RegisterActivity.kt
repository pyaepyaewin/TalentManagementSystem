package com.example.talentmanagementsystem.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import com.example.talentmanagementsystem.R
import com.example.talentmanagementsystem.mvp.contract.RegisterContract
import com.example.talentmanagementsystem.mvp.presenter.RegisterPresenterImpl
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity(), RegisterContract.RegisterView {
    override fun showError(error: String) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show()
    }

    private val registerPresenter: RegisterContract.RegisterPresenter by lazy {
        RegisterPresenterImpl()

    }

    override fun goToLoginPage() {
        intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        btnRegister.setOnClickListener {
            goToLoginPage()

        }
        btnBack.setOnClickListener {
            goToLoginPage()
        }
        var track = arrayOf("Android", "Php", "Java")
        val spinner = findViewById<Spinner>(R.id.spinner)
        val arrayAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, track)
        spinner.adapter = arrayAdapter
    }
}

