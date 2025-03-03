package com.example.travelmate.firstapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.travelmate.R

class travelmate_page1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.travelmate_layout1)
        // Referencia al botón "Salir"
        val btnLeave = findViewById<Button>(R.id.btnLeave)
        // Acción al hacer clic en el botón
        btnLeave.setOnClickListener {
            Toast.makeText(this, "Saliendo...", Toast.LENGTH_SHORT).show() // Evento Pop-Up
            finishAffinity() // Cierre de la app
        }

        // Referencia al botón "Siguiente"
        val btnNext = findViewById<Button>(R.id.btnLogIn)
        // Acción al hacer clic en el botón
        btnNext.setOnClickListener {
            Toast.makeText(this, "Entrando...", Toast.LENGTH_SHORT).show() // Evento Pop-Up
            val intent = Intent(this, travelmate_page2::class.java)
            startActivity(intent) // Inicio de Activity 2
        }
    } // Función "main()" para arrancar la app
}