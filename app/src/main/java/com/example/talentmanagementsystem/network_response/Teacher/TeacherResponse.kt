package com.example.talentmanagementsystem.network_response.Teacher

data class TeacherResponse(
    val data: List<Data>,
    val code: Int,
    val duration: Double,
    val errors: Errors,
    val meta: Meta,
    val success: Int
)