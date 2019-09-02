package com.example.talentmanagementsystem.network_response.Activity

import java.io.Serializable

data class Data(
    val activity_date: String,
    val activity_type_id: Int,
    val created_at: Any,
    val deleted_at: Any,
    val description: String,
    val id: Int,
    val image: String?=null,
    val speaker: String?=null,
    val title: String?=null,
    val updated_at: Any
) : Serializable