package com.example.talentmanagementsystem.network_response.AssignmentResponse

import java.io.Serializable

data class Complete(
    val file: String,
    val course_id: Int,
    val created_at: String,
    val deleted_at: Any,
    val due_date: String,
    val id: Int,
    val status: Int,
    val student_assignments: List<StudentAssignment>,
    val teacher_id: Int,
    val topic: String,
    val updated_at: String
):Serializable