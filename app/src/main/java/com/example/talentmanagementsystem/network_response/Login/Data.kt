package com.example.talentmanagementsystem.network_response.Login

data class Data(
    val address: String,
    val batch: Batch,
    val batch_id: Int,
    val created_at: Any,
    val date_of_birth: String,
    val email: String,
    val email_verified_at: Any,
    val expires: Int,
    val id: Int,
    val module: Module,
    val module_id: Int,
    val name: String,
    val phone: String,
    val photo: String,
    val token: String,
    val type: String,
    val updated_at: Any,
    val verified: Int
)