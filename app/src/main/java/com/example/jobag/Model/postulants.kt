package com.upc.pe.jobagapplication.Model

import com.google.gson.annotations.SerializedName

data class postulants (
    val id: Long,
    val firstname: String,
    val lastname: String,
    val email: String,
    val number: Int,
    val password: String,
    val document: String,
    val civil_status: String

)