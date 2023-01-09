package com.example.nourah_alhindi_retake1.models.data

import com.google.gson.annotations.SerializedName

data class UniversitiesItem(
    val alpha_two_code: String,
    val country: String,
    val domains: List<String>,
    val name: String,
    @SerializedName("state-province")
    val state: Any,
    val web_pages: List<String>
)