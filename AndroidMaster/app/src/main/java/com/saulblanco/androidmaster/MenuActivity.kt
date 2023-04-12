package com.saulblanco.androidmaster

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatButton
import com.saulblanco.androidmaster.firstApp.FirstAppActivity
import com.saulblanco.androidmaster.firstApp.ResultActivity
import com.saulblanco.androidmaster.imccalculator.ImcCalculatorActivity
import com.saulblanco.androidmaster.settings.SettingsActivity
import com.saulblanco.androidmaster.superheroapp.SuperHeroListActivity
import com.saulblanco.androidmaster.todoapp.TodoActivity

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val btnIMCApp =findViewById<AppCompatButton>(R.id.btnIMCApp)
        val btnSaludoApp =findViewById<AppCompatButton>(R.id.btnSaludar)
        val btnTODO = findViewById<AppCompatButton>(R.id.btnTODO)
        val btnSuperHero = findViewById<AppCompatButton>(R.id.btnSuperHero)
        val btnSettings = findViewById<AppCompatButton>(R.id.btnSettings)

        //---- LISTENERS ----
        btnSaludoApp.setOnClickListener {navigateToSaludApp()}
        btnIMCApp.setOnClickListener { navigateToIMCApp() }
        btnTODO.setOnClickListener { navigateToTodoApp() }
        btnSuperHero.setOnClickListener { navigateToSuperHeroApp() }
        btnSettings.setOnClickListener { navigatetoSettings() }
    }

    private fun navigatetoSettings() {
        val intent = Intent(this,SettingsActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToSuperHeroApp() {
        val intent = Intent(this,SuperHeroListActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToTodoApp() {
        val intent = Intent(this,TodoActivity::class.java)
        startActivity(intent)
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