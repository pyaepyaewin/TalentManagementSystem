package com.example.talentmanagementsystem.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.talentmanagementsystem.R
import com.example.talentmanagementsystem.database.FeedbackDataClass
import com.example.talentmanagementsystem.mvp.contract.FeedbackContract
import com.example.talentmanagementsystem.ui.adapter.adapters.FeedbackAdapter
import kotlinx.android.synthetic.main.activity_feedback.*

class FeedbackActivity : AppCompatActivity(), FeedbackContract.FeedbackView {
    override fun goToCreateFeedbackPage() {
        var intent = Intent(this, CreateFeedbackActivity::class.java)
        startActivity(intent)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feedback)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        arrow.setOnClickListener {
            onBackPressed()
            true

        }
        floatingActionButton.setOnClickListener {
            goToCreateFeedbackPage()
        }

        var feedback1 = FeedbackDataClass(
            "ToiletIssue", "Student No Name",
            "Lorem jdfnjhenfjnfjdjn bvdjvdjnvdjv dkndk nkdnd kdfndkfkd", "July7"
        )
        var feedback2 = FeedbackDataClass(
            "Need More Breakfast Time", "Student",
            "Lorem jdfnjhenfjnfjdjn bvdjvdjnvdjv dkndk nkdnd kdfndkfkd", "July8"
        )
        var feedback3 = FeedbackDataClass(
            "ToiletIssue", "Student No Name",
            "Lorem jdfnjhenfjnfjdjn bvdjvdjnvdjv dkndk nkdnd kdfndkfkd", "July7"
        )
        var feedback4 = FeedbackDataClass(
            "Need More Breakfast Time", "Student",
            "Lorem jdfnjhenfjnfjdjn bvdjvdjnvdjv dkndk nkdnd kdfndkfkd", "July8"
        )
        var feedback5 = FeedbackDataClass(
            "ToiletIssue", "Student No Name",
            "Lorem jdfnjhenfjnfjdjn bvdjvdjnvdjv dkndk nkdnd kdfndkfkd", "July7"
        )
        var feedback6 = FeedbackDataClass(
            "Need More Breakfast Time", "Student",
            "Lorem jdfnjhenfjnfjdjn bvdjvdjnvdjv dkndk nkdnd kdfndkfkd", "July8"
        )
        var feedbackArray =
            mutableListOf<FeedbackDataClass>(feedback1, feedback2, feedback3, feedback4, feedback5, feedback6)
        var adapter = FeedbackAdapter(this, R.layout.feedback, feedbackArray)
        rvFeedback.layoutManager = LinearLayoutManager(this)
        rvFeedback.adapter = adapter
    }

}

