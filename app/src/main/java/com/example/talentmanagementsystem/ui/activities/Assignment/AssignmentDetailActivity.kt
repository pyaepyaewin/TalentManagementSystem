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

    companion object{
        const val EXTRA="assignment"
        var data:Complete?=null
        fun newIntent(context: Context,data:Complete): Intent{
            val intent = Intent(context,AssignmentDetailActivity::class.java)
            intent.putExtra("Complete",data)
            return  intent
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_assignment_detail)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)

        //Log.d("hello",(intent.extras!!.getSerializable(EXTRA) as StudentAssignment).assignment_id.toString())
        data=intent.getSerializableExtra("Complete") as Complete?


        var assList = emptyList<StudentAssignment>()
       assList = data!!.student_assignments
       assignmentTitle.text= data?.topic
        //teacherName.text= data?.teacher_id.toString()
        mark.text= assList[0].mark.toString()
        arrow.setOnClickListener {
            onBackPressed()
            true
        }




    }
}
