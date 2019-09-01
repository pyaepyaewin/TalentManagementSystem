package com.example.talentmanagementsystem.network_response.FeedBack.PostFeedFack

data class PostFeedbackResponse(
    val data: Data,
    val code: Int,
    val duration: Double,
    val errors: Errors,
    val meta: Meta,
    val success: Int
)