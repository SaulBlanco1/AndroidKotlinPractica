package com.saulblanco.androidmaster

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatButton
import com.saulblanco.androidmaster.firstApp.FirstAppActivity
import com.saulblanco.androidmaster.firstApp.ResultActivity
import com.saulblanco.androidmaster.imccalculator.ImcCalculatorActivity

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val btnIMCApp =findViewById<AppCompatButton>(R.id.btnIMCApp)
        val btnSaludoApp =findViewById<AppCompatButton>(R.id.btnSaludar)

        //---- LISTENERS ----
        btnSaludoApp.setOnClickListener {navigateToSaludApp()}
        btnIMCApp.setOnClickListener { navigateToIMCApp() }

    }

    private fun navigateToIMCApp() {
        val intent = Intent(this,ImcCalculatorActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToSaludApp(){
        val intent = Intent(this, FirstAppActivity::class.java)
        startActivity(intent)
    }
}