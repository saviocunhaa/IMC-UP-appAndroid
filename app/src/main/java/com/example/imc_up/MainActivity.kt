package com.example.imc_up

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {

    private lateinit var btnCalcular: Button
    lateinit var txtAltura: EditText
    lateinit var txtPeso: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnCalcular = findViewById(R.id.btnCalcular)
        txtAltura = findViewById(R.id.txtEditAltura)
        txtPeso = findViewById(R.id.txtEditPeso)



        btnCalcular.setOnClickListener {
            val intent = Intent(this, ResultadoActivity::class.java)

            val peso = txtPeso.text.toString()
            val altura = txtAltura.text.toString()

            if (peso.isNotEmpty()  && altura.isNotEmpty()){

                intent.putExtra("peso", peso.toDouble())
                intent.putExtra("altura", altura.toDouble())

            }

            startActivity(intent)

        }

    }
}