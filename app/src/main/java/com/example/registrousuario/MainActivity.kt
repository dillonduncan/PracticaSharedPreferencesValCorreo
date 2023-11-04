package com.example.registrousuario

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import androidx.core.view.isNotEmpty
import com.example.registrousuario.Shared.Companion.prefs
import com.example.registrousuario.databinding.ActivityMain2Binding
import com.example.registrousuario.databinding.ActivityMainBinding
import java.util.regex.Pattern

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.apply {
            btnGuardar.setOnClickListener {Emailfocus(); Guardar(txtCorreo.text.toString())}
            btnEliminar.setOnClickListener {LimpiarTXT()}
            btnDatos.setOnClickListener {CambiarActivity()}
        }
        Emailfocus()
    }
    fun Emailfocus(){
        binding.txtCorreo.setOnFocusChangeListener { _, focused ->
            if (!focused){
                binding.tilCorreo.helperText=validEmail()
            }
        }
    }
    private fun validEmail(): String? {
        val emailtext=binding.txtCorreo.text.toString()
        if (Patterns.EMAIL_ADDRESS.matcher(emailtext).matches()){
            return "Correo invalido"
        }
        return null
    }
    fun CambiarActivity(){
        startActivity(Intent(this, MainActivity2::class.java))
    }
    fun LimpiarTXT(){
        binding.apply {
            txtNombre.setText("")
            txtCelular.setText("")
            txtCorreo.setText("")
            txtApellido.setText("")
            prefs.Borrar()
        }
    }
    @SuppressLint("ResourceAsColor")
    fun Guardar(email:String){
        var verificacion=Pattern.matches("^[A-Za-z]{1}[A-Za-z0-9]{3}([-._]{1}|)[A-Za-z0-9]{4,}@[a-z]{4,}[.][a-z]{2,}",email)
        binding.apply {
            if (txtCorreo.text!!.isNotEmpty() && txtApellido.text!!.isNotEmpty() && txtCelular.text!!.isNotEmpty() && txtNombre.text!!.isNotEmpty() && verificacion){
                prefs.GuardarCorreo(txtCorreo.text.toString())
                prefs.GuardarNombre(txtNombre.text.toString())
                prefs.GuardarApellido(txtApellido.text.toString())
                prefs.GuardarCelular(txtCelular.text.toString())
                Toast.makeText(this@MainActivity, "Guardo", Toast.LENGTH_SHORT).show()
            }
            else if(!verificacion){
                txtCorreo.error="Correo no valido"
                txtCorreo.setTextColor(R.color.rojo)
            }
            else if (txtCorreo.text!!.isBlank()){
                txtCorreo.error="Este campo es obligatorio"
            }
            else if (txtApellido.text!!.isBlank()){
                txtApellido.error="Este campo es obligatorio"
            }
            else if (txtCelular.text!!.isBlank()){
                txtCelular.error="Este campo es obligatorio"
            }
            else if (txtNombre.text!!.isBlank()){
                txtNombre.error="Este campo es obligatorio"
            }
        }
    }
}