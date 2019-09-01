package com.example.talentmanagementsystem.network_response.AssignmentResponse

data class StudentAssignment(
    val file: String,
    val assignment_id: Int,
    val created_at: String,
    val deleted_at: Any,
    val id: Int,
    val mark: Int,
    val status: Int,
    val student_id: Int,
    val submitted_date: String,
    val updated_at: String
)