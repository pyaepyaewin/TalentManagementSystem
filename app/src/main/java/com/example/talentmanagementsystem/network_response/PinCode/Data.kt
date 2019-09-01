package com.example.talentmanagementsystem.network_response.PinCode

import java.io.Serializable

data class Data(
    val batch_id: Int,
    val created_at: Any,
    val deleted_at: Any,
    val id: Int,
    val image: String,
    val name: String,
    val updated_at: Any
):Serializable