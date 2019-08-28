package com.example.talentmanagementsystem.ui.activities.Activity

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.talentmanagementsystem.R
import com.example.talentmanagementsystem.network_response.Activity.Data
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_activities.arrow
import kotlinx.android.synthetic.main.activity_detail_activities.*

class DetailActivitiesActivity : AppCompatActivity() {
    companion object {
       var data : Data? = null
        fun newIntent(context: Context ,data : Data): Intent {
            val intent = Intent(context, DetailActivitiesActivity::class.java)
            intent.putExtra("Data", data)
            return intent
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_activities)

        data = intent.getSerializableExtra("Data") as Data?


        activityTitle.text=
            data?.title
        speaker.text= data?.speaker
        description1.text= data?.description
        Picasso.get().load(data?.image).into(activityImage)
        arrow.setOnClickListener {
            onBackPressed()
            true
        }
    }
}
