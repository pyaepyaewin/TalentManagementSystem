package com.example.talentmanagementsystem.network_response.AssignmentResponse

data class Data(
    val complete: List<Complete>,
    val incomplete: List<Incomplete>
)