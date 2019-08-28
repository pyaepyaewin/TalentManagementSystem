package com.example.talentmanagementsystem.ui.activities.Teacher

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.talentmanagementsystem.R
import com.example.talentmanagementsystem.network_response.Teacher.Data
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_teacher_detail.*

class TeacherDetailActivity : AppCompatActivity() {
companion object{
    var data:Data?=null
    fun newIntent(context: Context, data : Data): Intent {
        val intent = Intent(context, TeacherDetailActivity::class.java)
        //intent.putExtra("Data",data)
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
        data=intent.getSerializableExtra("Data")as Data?
        teacherName.text=data?.name
        teacherPosition.text= data?.position
//        module.text= data?.module
//        Picasso.get().load(data?.photo).into(teacherImage)

    }
}
