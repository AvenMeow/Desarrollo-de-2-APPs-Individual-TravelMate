package com.example.travelmate.firstapp

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.travelmate.R
import java.util.Calendar

class travelmate_page2 : AppCompatActivity() {
    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.travelmate_layout2)
        // Referencia al botón "Volver"
        val btnBack = findViewById<Button>(R.id.btnLeave1)
        // Acción al hacer clic en el botón
        btnBack.setOnClickListener {
            Toast.makeText(this, "Regresando...", Toast.LENGTH_SHORT).show() // Evento Pop-Up
            val intent = Intent(this, travelmate_page1::class.java)
            startActivity(intent) // Inicio de Activity 1
        }

        // Referencia a los campos "Fecha de nacimiento" y "Selector de fechas"
        val showBirthday = findViewById<TextView>(R.id.dateBirthday)
        val btnBirthday = findViewById<Button>(R.id.btnDate)
        // Acción al hacer clic en el botón
        btnBirthday.setOnClickListener {
            // Obtener la fecha actual
            val calendar = Calendar.getInstance()
            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val day = calendar.get(Calendar.DAY_OF_MONTH)
            // Abrir el selector de fechas
            val pickDates = DatePickerDialog(this, { _, selectedYear, selectedMonth, selectedDay ->
                // Mostrar la fecha seleccionada
                val Date = "$selectedDay/${selectedMonth + 1}/$selectedYear"
                showBirthday.text = Date
            }, year, month, day)
            pickDates.show()
        }

        // Referencias a los campos del formulario
        val Name = findViewById<EditText>(R.id.inputName)
        val Email = findViewById<EditText>(R.id.inputEmail)
        val Password = findViewById<EditText>(R.id.inputPassword)
        val Birthday = findViewById<TextView>(R.id.dateBirthday)
        val Gender = findViewById<RadioGroup>(R.id.Gender)
        val btnNext1 = findViewById<Button>(R.id.btnSignUp)
             // Acción al hacer clic en el botón
             btnNext1.setOnClickListener {
                // Recopilar datos del formulario
                val name = Name.text.toString()
                val email = Email.text.toString()
                val password = Password.text.toString()
                val birthday = Birthday.text.toString()

                // Obtener género
                val GenderType = Gender.checkedRadioButtonId
                val gender = if (GenderType != -1) {
                        findViewById<RadioButton>(GenderType).text.toString()
                } else {"No especificado"}

                // Validar campos obligatorios
                if (name.isEmpty() || email.isEmpty() || password.isEmpty() || birthday.isEmpty()) {
                        Toast.makeText(this, "Por favor, completa todos los campos", Toast.LENGTH_SHORT).show()
                } else {
                    // Crear y mostrar el AlertDialog
                    val message = """
                    Nombre: $name
                    Correo: $email
                    Contraseña: $password
                    Fecha de nacimiento: $birthday
                    Género: $gender
                """.trimIndent()

                        AlertDialog.Builder(this)
                            .setTitle("Confirmación de Registro")
                            .setMessage(message)
                            .setPositiveButton("Aceptar") { dialog, _ ->
                                dialog.dismiss() // Cierre del cuadro de diálogo
                                Toast.makeText(this, "¡Inscripción completada!", Toast.LENGTH_SHORT).show()
                                val intent = Intent(this, travelmate_page3::class.java)
                                startActivity(intent) // Inicio de Activity 3
                            }
                            .setNegativeButton("Cancelar") { dialog, _ ->
                                dialog.dismiss() // Cierre del cuadro de diálogo
                            }
                            .show()}
             }
    } // Función "main()" para arrancar la app
}
