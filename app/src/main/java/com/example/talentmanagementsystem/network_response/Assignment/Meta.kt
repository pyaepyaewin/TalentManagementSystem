package com.example.talentmanagementsystem.network_response.Assignment

data class Meta(
    val endpoint: String,
    val limit: Int,
    val method: String,
    val offset: Int,
    val total: Int
)