package com.example.talentmanagementsystem.network_response.Login

data class LoginResponse(
    val data: Data,
    val code: Int,
    val duration: Double,
    val errors: Errors,
    val meta: Meta,
    val success: Int
)