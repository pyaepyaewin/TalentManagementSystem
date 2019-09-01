package com.example.talentmanagementsystem.network_response.Register

data class RegisterResponse(
    val data: Data?=null,
    val code: Int?=null,
    val duration: Double?=null,
    val errors: Errors?=null,
    val meta: Meta?=null,
    val success: Int?=null
)