package com.example.talentmanagementsystem.network_response.AssignmentResponse

data class AssignmentResponse(
    val data: Data,
    val code: Int,
    val duration: Double,
    val errors: Errors,
    val meta: Meta,
    val success: Int
)