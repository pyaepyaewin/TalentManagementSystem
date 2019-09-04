package com.example.talentmanagementsystem.ui.activities.Teacher

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.talentmanagementsystem.R
import com.example.talentmanagementsystem.network_response.Teacher.Data
import kotlinx.android.synthetic.main.activity_teacher_detail.*

class TeacherDetailActivity : AppCompatActivity() {
companion object{
    const val EXTRA_NAME = "name"
    const val EXTRA_POSITION = "position"
    const val EXTRA_MODULE="module"
    const val EXTRA_EMAIL="email"
    var data: Data?=null
    fun newIntent(context: Context,name: String , position: String,email:String): Intent {
        val intent = Intent(context, TeacherDetailActivity::class.java)
        intent.putExtra(EXTRA_NAME,name)
        intent.putExtra(EXTRA_POSITION,position)
        intent.putExtra(EXTRA_EMAIL,email)
        return intent
    }
}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_teacher_detail)
        arrow.setOnClickListener {
            onBackPressed()
            true
        }
        /*data=intent.getSerializableExtra("Data")as Data
        teacherName.text=data?.name
        teacherPosition.text= data?.position*/
        teacherName.text = intent.getStringExtra(EXTRA_NAME).toString()
        teacherPosition.text = intent.getStringExtra(EXTRA_POSITION).toString()
        email.text=intent.getStringExtra(EXTRA_EMAIL).toString()
//        module.text= data?.module
//        Picasso.get().load(data?.photo).into(teacherImage)

    }
}
