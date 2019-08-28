package com.example.talentmanagementsystem.ui.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.talentmanagementsystem.R
import com.example.talentmanagementsystem.mvp.contract.MainContract
import com.example.talentmanagementsystem.mvp.presenter.MainPresenterImpl
import com.example.talentmanagementsystem.ui.activities.Activity.ActivitiesActivity
import com.example.talentmanagementsystem.ui.activities.Teacher.TeacherActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainContract.MainView {
    override fun goToFeedbackPage() {
        intent = Intent(this, FeedbackActivity::class.java)
        startActivity(intent)
    }

    override fun goToTeacherPage() {
        intent = Intent(this, TeacherActivity::class.java)
        startActivity(intent)
    }

    override fun goToInfoPage() {
        intent=Intent(this,InfoActivity::class.java)
        startActivity(intent)
    }

    override fun goToSchedulePage() {
        intent = Intent(this, ScheduleActivity::class.java)
        startActivity(intent)
    }

    override fun goToAssignmentPage() {
        intent = Intent(this, AssignmentActivity::class.java)
        startActivity(intent)
    }

    override fun goToActivityPage() {
        intent = Intent(this, ActivitiesActivity::class.java)
        startActivity(intent)
    }

    private val mainPresenter: MainContract.MainPresenter by lazy {
        MainPresenterImpl()
    }

    override fun goToProfilePage() {
        intent = Intent(this, ProfileActivity::class.java)
        startActivity(intent)
    }

    companion object {
        fun newIntent(context: Context): Intent {
            val intent = Intent(context, MainActivity::class.java)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainPresenter.attachView(this)

        cardProfile.setOnClickListener {
            goToProfilePage()
        }
        activity.setOnClickListener {
            goToActivityPage()
        }
        assignment.setOnClickListener {
            goToAssignmentPage()
        }
        schedule.setOnClickListener {
            goToSchedulePage()
        }
        feedback.setOnClickListener {
            goToFeedbackPage()
        }
        teacher.setOnClickListener {
            goToTeacherPage()
        }
        aboutUs.setOnClickListener {
            goToInfoPage()
        }
    }
}
