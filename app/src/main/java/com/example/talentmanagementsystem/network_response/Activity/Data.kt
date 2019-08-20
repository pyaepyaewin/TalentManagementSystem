package com.example.talentmanagementsystem.network_response.Activity

data class Data(
    val activity_date: String,
    val activity_type_id: Int,
    val created_at: Any,
    val deleted_at: Any,
    val description: String,
    val id: Int,
    val image: String,
    val speaker: String,
    val title: String,
    val updated_at: Any
)