package com.example.talentmanagementsystem.network_response.FeedBack.GetFeedBack

import java.sql.Date
import java.time.format.DateTimeFormatter

data class Data(
    val created_at: Any,
    val description: String,
    val id: Int,
    val status: Int,
    val student_id: Int,
    val title: String,
    val updated_at: Any,
    val votes_count: Int
)