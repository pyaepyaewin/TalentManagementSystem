package com.example.talentmanagementsystem.network_response.Assignment

data class AssignmentResponse(
    val data: List<Any>,
    val code: Int,
    val duration: Double,
    val errors: Errors,
    val meta: Meta,
    val success: Int
)