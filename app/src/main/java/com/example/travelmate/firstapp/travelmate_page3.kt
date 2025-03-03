package com.example.travelmate.firstapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.travelmate.R

class travelmate_page3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.travelmate_layout3)
        // Referencia al botón "Salir"
        val btnLeave1 = findViewById<Button>(R.id.btnLeave2)
        // Acción al hacer clic en el botón
        btnLeave1.setOnClickListener {
            Toast.makeText(this, "Saliendo...", Toast.LENGTH_SHORT).show() // Evento Pop-Up
            finishAffinity() // Cierre de la app
        }
    }
}