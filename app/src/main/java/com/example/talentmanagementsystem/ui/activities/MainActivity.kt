package com.example.talentmanagementsystem.ui.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import com.example.talentmanagementsystem.R
import com.example.talentmanagementsystem.data.models.SharedPreference
import com.example.talentmanagementsystem.mvp.contract.MainContract
import com.example.talentmanagementsystem.mvp.presenter.MainPresenterImpl
import com.example.talentmanagementsystem.network_response.Login.Data
import com.example.talentmanagementsystem.ui.activities.Activity.ActivitiesActivity
import com.example.talentmanagementsystem.ui.activities.Assignment.AssignmentActivity
import com.example.talentmanagementsystem.ui.activities.Feedback.FeedbackActivity
import com.example.talentmanagementsystem.ui.activities.Teacher.TeacherActivity
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainContract.MainView {

    override fun goToFeedbackPage() {
        val feedbackIntent = Intent(this, FeedbackActivity::class.java)
        startActivity(feedbackIntent)
    }

    override fun goToTeacherPage() {
        val teacherIntent = Intent(this, TeacherActivity::class.java)
        startActivity(teacherIntent)
    }

    override fun goToInfoPage() {
        val infoIntent = Intent(this, InfoActivity::class.java)
        startActivity(infoIntent)
    }

    override fun goToSchedulePage() {
        val scheduleIntent = Intent(this, ScheduleActivity::class.java)
        startActivity(scheduleIntent)
    }

    override fun goToAssignmentPage() {
        val assignmentIntent = Intent(this, AssignmentActivity::class.java)
        startActivity(assignmentIntent)
    }

    override fun goToActivityPage() {
        val activityIntent = Intent(this, ActivitiesActivity::class.java)
        startActivity(activityIntent)
    }

    private val mainPresenter: MainContract.MainPresenter by lazy {
        MainPresenterImpl()
    }

    override fun goToProfilePage() {

        val profileIntent = ProfileActivity.newIntent(this)
        startActivity(profileIntent)
    }

    companion object {
        var user: Data? = null

        fun newIntent(context: Context): Intent {
            val intent = Intent(context, MainActivity::class.java)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        mainPresenter.attachView(this)
        userName.text=SharedPreference.getInstance(this).getUserName()

       //     Picasso.get().load(profile_link).into(profile)

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
       info.setOnClickListener {
            goToInfoPage()
        }
    }
}
