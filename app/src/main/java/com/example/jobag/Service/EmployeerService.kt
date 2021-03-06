package com.example.jobag.Service

import com.upc.pe.jobagapplication.Model.employeers
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

const val BASE_URL1 = "https://jobagbackend.herokuapp.com/"
interface EmployeerInterface {

    //Get
    @GET("api/employeers/{id}")
    fun getEmployeer(@Path("id") email: Long): Call<employeers>
}

object EmployeerService {
    val employeerInstance: EmployeerInterface
    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL1)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        employeerInstance = retrofit.create(EmployeerInterface::class.java)
    }
}