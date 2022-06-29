package com.upc.pe.jobagapplication.Model

import com.google.gson.annotations.SerializedName

data class employeers (
    val id : Long,
    val firstname: String,
    val lastname: String,
    val email: String,
    val number: Int,
    val password: String,
    val document: String,
    val posicion: String
        )