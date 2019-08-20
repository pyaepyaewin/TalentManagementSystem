package com.example.talentmanagementsystem.ui.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.talentmanagementsystem.R
import kotlinx.android.synthetic.main.activity_activities.arrow
import kotlinx.android.synthetic.main.activity_detail_activities.*

class DetailActivitiesActivity : AppCompatActivity() {
    companion object {
        const val TITLE = "title"
        const val NAME = "name"
        const val IMAGE = "image"
        const val DESCRIPTION="description"
        fun newIntent(context: Context, title: String, image: Int, name: String,description:String): Intent {
            val intent = Intent(context, DetailActivitiesActivity::class.java)
            intent.putExtra(TITLE, title)
            intent.putExtra(NAME,name)
            intent.putExtra(IMAGE, image)
            intent.putExtra(DESCRIPTION, description)
            return intent
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_activities)
        arrow.setOnClickListener {
            onBackPressed()
            true
        }
        var title=intent.getStringExtra(TITLE)
        var name = intent.getStringExtra(NAME)
        var description = intent.getStringExtra(DESCRIPTION)
        var image = intent.getIntExtra(IMAGE, 0)
        activityTitle.text = title
        speaker.text=name
        description1.text = description
        activityImage.setImageResource(image)
    }
}
