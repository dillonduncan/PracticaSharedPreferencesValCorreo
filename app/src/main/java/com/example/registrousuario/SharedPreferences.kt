package com.example.registrousuario

import android.content.Context

class SharedPreferences(context:Context) {
    val storage=context.getSharedPreferences("DB", 0)
    fun GuardarCorreo(correo:String){
        storage.edit().putString("Correo_Usuario",correo).apply()
    }
    fun GuardarNombre(nombre:String){
        storage.edit().putString("Nombre_Usuario",nombre).apply()
    }
    fun GuardarApellido(apellido:String){
        storage.edit().putString("Apellido_Usuario",apellido).apply()
    }
    fun GuardarCelular(celular:String){
        storage.edit().putString("cel_Usuario",celular).apply()
    }
    fun ObtenerCorreo():String{
        return storage.getString("Correo_Usuario","").toString()
    }
    fun ObtenerNombre():String{
        return storage.getString("Nombre_Usuario","").toString()
    }
    fun ObtenerApellido():String{
        return storage.getString("Apellido_Usuario","").toString()
    }
    fun ObtenerCel():String{
        return storage.getString("cel_Usuario","").toString()
    }
    fun Borrar(){
        storage.edit().clear()
    }
}