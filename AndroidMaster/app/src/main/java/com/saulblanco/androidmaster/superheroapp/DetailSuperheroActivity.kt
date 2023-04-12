package com.saulblanco.androidmaster.superheroapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import com.saulblanco.androidmaster.R
import com.saulblanco.androidmaster.databinding.ActivityDetailSuperheroBinding
import com.saulblanco.androidmaster.databinding.ActivitySuperHeroListBinding
import com.squareup.picasso.Picasso
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.math.roundToInt

class DetailSuperheroActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_ID = "extra_id"
    }

    private lateinit var binding : ActivityDetailSuperheroBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityDetailSuperheroBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val id: String = intent.getStringExtra(EXTRA_ID).orEmpty()

        getSuperheroInformation(id)

    }

    private fun createUI(superhero: SuperHeroDetailResponse) {
        Picasso.get().load(superhero.image.url).into(binding.ivSuperHero)
        binding.tvSuperheroName.text=superhero.name
        prepareStats(superhero.powerstats)
        binding.tvSuperheroName.text=superhero.biography.fullName
        binding.tvPublisher.text=superhero.biography.publisher

    }

    private fun prepareStats(powerstats: PowerStatsResponse) {
        binding.viewCombat
        updateHeight(binding.viewIntelligence,powerstats.intelligence)
        updateHeight(binding.viewDurability,powerstats.durability)
        updateHeight(binding.viewSpeed,powerstats.speed)
        updateHeight(binding.viewStrength,powerstats.strength)
        updateHeight(binding.viewPower,powerstats.power)
        updateHeight(binding.viewCombat,powerstats.combat)

    }

    private fun updateHeight(view: View, stat:String){

        val params = view.layoutParams
        params.height= pixelToDp(stat.toFloat())
        view.layoutParams=params
    }

    private fun pixelToDp(px:Float):Int{
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,px,resources.displayMetrics).roundToInt()

    }


    private fun getSuperheroInformation(id: String) {
        CoroutineScope(Dispatchers.IO).launch {
            val superHeroDetail =
                getRetrofit().create(ApiService::class.java).getSuperheroDetail(id)

            if(superHeroDetail.body() !=null){
                runOnUiThread{ createUI(superHeroDetail.body()!!)}
            }

        }

    }

    private fun getRetrofit(): Retrofit {
        //Crea un Objeto retrofit y lo devuelve//AddConverterFactory, convierte el JSON
        //en un objeto Retrofit
        return Retrofit
            .Builder()
            .baseUrl("https://superheroapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    }

}