package com.example.talentmanagementsystem.ui.activities.Feedback

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import com.example.talentmanagementsystem.R
import com.example.talentmanagementsystem.data.models.SharedPreference
import com.example.talentmanagementsystem.mvp.contract.CreateFeedbackContract
import com.example.talentmanagementsystem.mvp.presenter.CreateFeedbackPresenterImpl
import kotlinx.android.synthetic.main.activity_create_feedback.*

class CreateFeedbackActivity : AppCompatActivity(),CreateFeedbackContract.CreateFeedbackView {
    val preference = SharedPreference.getInstance(this)
    private val createFeedbackPresenter: CreateFeedbackContract.CreateFeedbackPresenter by lazy {
        CreateFeedbackPresenterImpl(this)
    }
    override fun feedbackSuccess(message: String) {

    }

    override fun feedbackFail(error: String) {
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_feedback)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        btnCreate.setOnClickListener {
            var title=edtTitle.text.toString()
            var description=edtDescription.text.toString()
            var student_id=SharedPreference.getInstance(this).getUserId()
            createFeedbackPresenter.sendFeedBack(student_id,title,description)
        }
        arrow.setOnClickListener {
            onBackPressed()
            true
        }
    }

}
