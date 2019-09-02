package com.example.talentmanagementsystem.ui.activities.Assignment

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.WindowManager
import com.example.talentmanagementsystem.R
import com.example.talentmanagementsystem.network_response.AssignmentResponse.Complete
import com.example.talentmanagementsystem.network_response.AssignmentResponse.Data
import com.example.talentmanagementsystem.network_response.AssignmentResponse.StudentAssignment
import kotlinx.android.synthetic.main.activity_assignment.*
import kotlinx.android.synthetic.main.activity_assignment_detail.*
import kotlinx.android.synthetic.main.activity_assignment_detail.arrow

class AssignmentDetailActivity : AppCompatActivity() {
    var topic: String? = null
    var mark: Int =0

    companion object {
        const val EXTRA = "assignment"
        const val EXTRA_TOPIC = "topic"
        const val EXTRA_MARK = "mark"

        fun newIntent(context: Context, topic: String, mark: Int): Intent {
            val intent = Intent(context, AssignmentDetailActivity::class.java)
            intent.putExtra(EXTRA_TOPIC, topic)
            intent.putExtra(EXTRA_MARK, mark)
            return intent
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_assignment_detail)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)

        //Log.d("hello",(intent.extras!!.getSerializable(EXTRA) as StudentAssignment).assignment_id.toString())
        topic = intent.getStringExtra(EXTRA_TOPIC)
        mark=intent.getIntExtra(EXTRA_MARK,0)



        assignmentTitle.text =topic
        //teacherName.text= data?.teacher_id.toString()
        tvmark.text = mark.toString()
        arrow.setOnClickListener {
            onBackPressed()
            true
        }


    }
}
