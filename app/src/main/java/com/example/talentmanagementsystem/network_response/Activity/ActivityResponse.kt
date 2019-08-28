package com.example.talentmanagementsystem.network_response.Activity

data class ActivityResponse(
    val data: List<Data>,
    val code: Int,
    val duration: Double,
    val errors: Errors,
    val meta: Meta,
    val success: Int
)