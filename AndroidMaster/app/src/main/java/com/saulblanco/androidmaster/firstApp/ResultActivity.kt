package com.saulblanco.androidmaster.firstApp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.saulblanco.androidmaster.R

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        val tvResult=findViewById<TextView>(R.id.tvResult)

        //extras? para que sea nulleable, getString porque sabemos que recogemos un String,
        // orEmpty= si está vacío pinta un String vacío
        val name: String = intent.extras?.getString("EXTRA_NAME").orEmpty()

        tvResult.text="Hola $name"

    }
}