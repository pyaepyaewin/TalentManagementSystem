package com.example.talentmanagementsystem.network_response.ChangePasw

import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("code")
    val code: Int,
    @SerializedName("message")
    val message: String
)