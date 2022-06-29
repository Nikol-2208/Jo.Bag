package com.example.jobag.Empleador

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import com.example.jobag.HomeActivity
import com.example.jobag.R
import com.example.jobag.RegisterActivity
import com.example.jobag.Service.EmployeerService
import com.example.jobag.SharedPreferences
import com.upc.pe.jobagapplication.Model.employeers
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivityEmpleador : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val sharedPreferences = SharedPreferences(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_empleador)

        val etUser = findViewById<EditText>(R.id.et_email_e)
        val etPassword = findViewById<EditText>(R.id.et_password_e)
        val btLogin = findViewById<Button>(R.id.bt_Login_e)
        val btRegister = findViewById<Button>(R.id.bt_Register_e)

        btLogin.setOnClickListener {

            val name = etUser.text.toString()
            val password = etPassword.text.toString()
            if (name.isNotBlank() && password.isNotBlank()) {
                val id =  sharedPreferences.getValues("id")
                if(!id.isNullOrBlank()){
                    validateEmployeer()
                }
            }
        }

        btRegister.setOnClickListener {

            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }
    private fun validateEmployeer() {
        val sharedPreferences = SharedPreferences(this@LoginActivityEmpleador)


        val id =  sharedPreferences.getValues("id").toString().toLong()
        val requestPost = EmployeerService.employeerInstance.getEmployeer(id)
        requestPost.enqueue(object : Callback<employeers> {
            override fun onFailure(call: Call<employeers>, t: Throwable) {
                Log.d("Employeer", "Error in Fetching")

            }
            override fun onResponse(call: Call<employeers>, response: Response<employeers>) {
                if(response.isSuccessful){
                    val intent = Intent(this@LoginActivityEmpleador, HomeActivity::class.java)
                    startActivity(intent)
                }

            }
        })
    }
}