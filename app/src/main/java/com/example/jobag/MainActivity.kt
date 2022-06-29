package com.example.jobag

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.core.view.isInvisible
import com.example.jobag.Empleador.LoginActivityEmpleador
import com.example.jobag.Postulante.LoginActivityPostulante

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnLoginPostulante=findViewById<Button>(R.id.bt_Login_Postulante)
        val btnLoginEmpleador=findViewById<Button>(R.id.bt_Login_Empleador)
        val tvRegister=findViewById<TextView>(R.id.tv_CreateAccount)

        btnLoginEmpleador.setOnClickListener {
            val intent =Intent(this, LoginActivityEmpleador::class.java)
            startActivity(intent)
        }
        btnLoginPostulante.setOnClickListener {
            val intent =Intent(this, LoginActivityPostulante::class.java)
            startActivity(intent)
        }
        tvRegister.setOnClickListener {
            val intent =Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }



    }
}