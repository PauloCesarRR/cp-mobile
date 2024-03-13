package com.example.myapplication

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var etAltura: EditText
    private lateinit var rbMasculino: RadioButton
    private lateinit var rbFeminino: RadioButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setTheme(androidx.appcompat.R.style.Theme_AppCompat_Light_NoActionBar)
        etAltura = findViewById(R.id.etAltura)
        rbMasculino = findViewById(R.id.rbMasculino)
        rbFeminino = findViewById(R.id.rbFeminino)
    }

    fun calcularPesoIdeal(view: View) {
        val altura = etAltura.text.toString().toDouble()
        val sexo = if (rbMasculino.isChecked) "masculino" else "feminino"
        var pesoIdeal: Double

        when (sexo) {
            "masculino" -> pesoIdeal = (72.7 * altura) - 58
            "feminino" -> pesoIdeal = (62.1 * altura) - 44.7
            else -> {
                Toast.makeText(this, "Selecione o sexo", Toast.LENGTH_SHORT).show()
                return
            }
        }

        Toast.makeText(this, "Peso ideal: %.2f kg".format(pesoIdeal), Toast.LENGTH_SHORT).show()
    }
}