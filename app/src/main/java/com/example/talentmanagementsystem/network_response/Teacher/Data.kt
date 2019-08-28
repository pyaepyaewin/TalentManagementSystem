package com.example.talentmanagementsystem.network_response.Teacher

data class Data(
    val address: String,
    val course: Course,
    val course_id: Int,
    val created_at: Any,
    val email: String,
    val id: Int,
    val module: Module,
    val module_id: Int,
    val name: String,
    val phone: String,
    val photo: Any,
    val position: String,
    val updated_at: Any,
    val verified: Int
)