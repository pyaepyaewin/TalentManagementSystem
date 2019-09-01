package com.example.talentmanagementsystem.ui.activities.Feedback

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.WindowManager
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.talentmanagementsystem.R
import com.example.talentmanagementsystem.mvp.contract.FeedbackContract
import com.example.talentmanagementsystem.mvp.presenter.FeedbackPresenterImpl
import com.example.talentmanagementsystem.network_response.FeedBack.GetFeedBack.Data
import com.example.talentmanagementsystem.ui.adapter.adapters.FeedbackAdapter
import kotlinx.android.synthetic.main.activity_feedback.*

class FeedbackActivity : AppCompatActivity(), FeedbackContract.FeedbackView {
    private lateinit var feedbackList1: List<Data>
    private val feedbackAdapter:FeedbackAdapter by lazy {
        FeedbackAdapter()
    }
private val feedbackPresenter:FeedbackContract.FeedbackPresenter by lazy {
    FeedbackPresenterImpl(this)
}




    override fun showFeedbackList(feedbackList1: List<Data>) {
        //feedbackList = feedbackList1
        this.feedbackAdapter.setNewList(feedbackList1)

    }

    override fun goToCreateFeedbackPage() {
        var intent = Intent(this, CreateFeedbackActivity::class.java)
        startActivity(intent)
    }
    override fun showError(error: String) {
        Toast.makeText(applicationContext,error,Toast.LENGTH_SHORT).show()

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feedback)
        rvFeedback.apply {
            layoutManager = LinearLayoutManager(applicationContext)
            adapter = feedbackAdapter
        }
        feedbackPresenter.attachView(this)
        Log.d("feedback", "******")
        feedbackPresenter.loadFeedBacks()
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        arrow.setOnClickListener {
            onBackPressed()
            true

        }
        floatingActionButton.setOnClickListener {
            goToCreateFeedbackPage()
        }


    }

}

