package com.example.talentmanagementsystem.network_response.FeedBack.PostFeedFack

data class Data(
    val created_at: String,
    val description: String,
    val id: Int,
    val student_id: String,
    val title: String,
    val updated_at: String
)