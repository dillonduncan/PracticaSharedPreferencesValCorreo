package com.example.registrousuario

import android.app.Application

class Shared:Application() {
    companion object{
        lateinit var prefs:SharedPreferences
    }
    override fun onCreate() {
        super.onCreate()
        prefs=SharedPreferences(applicationContext)
    }
}