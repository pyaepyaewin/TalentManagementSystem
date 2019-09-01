package com.example.talentmanagementsystem.network_response.FeedBack.GetFeedBack

data class FeedbackResponse(
    val data: List<Data>,
    val code: Int,
    val duration: Double,
    val errors: Errors,
    val meta: Meta,
    val success: Int
)