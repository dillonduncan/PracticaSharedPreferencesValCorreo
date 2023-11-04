package com.example.registrousuario

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.registrousuario.Shared.Companion.prefs
import com.example.registrousuario.databinding.ActivityMain2Binding
import com.example.registrousuario.databinding.ActivityMainBinding

class MainActivity2 : AppCompatActivity() {
    lateinit var binding: ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        ObtenerDatos()
        binding.btnAtras.setOnClickListener { Volver() }
    }
    fun ObtenerDatos(){
        binding.apply {
            txtCorreo2.text= prefs.ObtenerCorreo()
            txtNombre2.text= prefs.ObtenerNombre()
            txtApellido2.text= prefs.ObtenerApellido()
            txtCel2.text= prefs.ObtenerCel()
        }
    }
    fun Volver(){
        startActivity(Intent(this,MainActivity::class.java))
    }
}