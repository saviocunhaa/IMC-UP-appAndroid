package com.example.imc_up

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ResultadoActivity : AppCompatActivity() {

    private lateinit var textPeso: TextView
    private lateinit var textAltura: TextView
    private lateinit var textDiagnostico: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)

        textPeso = findViewById(R.id.textPeso)
        textAltura = findViewById(R.id.textAltura)
        textDiagnostico = findViewById(R.id.textDiagnostico)


        val bundle = intent.extras
        if (bundle != null) {

            val peso = bundle.getDouble("peso")
            val altura = bundle.getDouble("altura")

            textPeso.text = "Peso infomado: $peso kg "
            textAltura.text = "Altura infomada: $altura m"


            val imc = peso / (altura * altura)

            if (imc < 18.5) {
                textDiagnostico.text = "IMC: $imc, BAIXO"
            } else if ((imc >= 18.5) && (imc <= 24.9)) {
                textDiagnostico.text = "IMC: $imc, NORMAL"
            } else if ((imc >= 25) && (imc <= 29.9)) {
                textDiagnostico.text = "IMC: $imc, SOBREPESO"
            }
            else if((imc >= 30) && (imc <= 39.9)) {
                textDiagnostico.text = "IMC: $imc, OBESIDADE"
            }
        }
    }
}