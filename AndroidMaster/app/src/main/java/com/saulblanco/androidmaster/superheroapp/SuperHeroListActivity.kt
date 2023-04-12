package com.saulblanco.androidmaster.superheroapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.widget.SearchView
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.saulblanco.androidmaster.R
import com.saulblanco.androidmaster.databinding.ActivitySuperHeroListBinding
import com.saulblanco.androidmaster.superheroapp.DetailSuperheroActivity.Companion.EXTRA_ID
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class SuperHeroListActivity : AppCompatActivity() {

    //Este es el view binding, el nombre empieza por Activity + El nombre de la activity
    private lateinit var binding : ActivitySuperHeroListBinding

    private lateinit var retrofit: Retrofit
    private lateinit var adapter: SuperheroAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Enlazas el binding a la vista
        binding = ActivitySuperHeroListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //binding.searchView -> Para nombrar un elemento se hace así de FACIL
        retrofit=getRetrofit()
        initUI()



    }

    private fun initUI() {
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            //Listener,se llama cada vez que se pulsa el botón de buscar
            //Siempre se retorna false
            override fun onQueryTextSubmit(query: String?): Boolean {
                //orEmpty() devuelve el texto o un vacío
                searchByName(query.orEmpty())

                return false
            }



            //Listener,se llama cada vez que se escribe algo
            override fun onQueryTextChange(newText: String?) = false


        })
        adapter= SuperheroAdapter{navigateToDetail(it)}
        binding.rvSuperHero.setHasFixedSize(true)
        binding.rvSuperHero.layoutManager=LinearLayoutManager(this)
        binding.rvSuperHero.adapter=adapter

    }

    private fun searchByName(query: String) {
        //true ->visible //false ->Invisible
        binding.progressBar.isVisible = true

        //Ponermos IO para lanzar en un hilo secundario, se usa para trabajar con BD
        //o para trabajos largos // T*do lo que se encuentre dentro del launch(), se lanzará
        //en  un hilo secundario
        CoroutineScope(Dispatchers.IO).launch{
            val myResponse: Response<SuperHeroeDataResponse> =retrofit.create(ApiService::class.java).getSuperheroes(query)
            if(myResponse.isSuccessful){
                Log.i("Saul","Funciona :)")
                //Dentro del .body() está la respuesta
               val response:SuperHeroeDataResponse? = myResponse.body()
                if(response!=null){
                    runOnUiThread{
                        adapter.updateList(response.superheroes)
                    }

                    Log.i("Saul",response.toString())
                    //Para modificar UI se hace en el hilo principal
                    //con "runOnUiThread{}" se ejecuta en el hilo principal el código que se
                    //encuentre dentro
                    runOnUiThread{
                        binding.progressBar.isVisible =false
                    }
                }



            }else{
                Log.i("Saul","No FUNCIONA :(")
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

    private fun navigateToDetail(id:String){
        val intent= Intent(this,DetailSuperheroActivity::class.java)
        intent.putExtra(EXTRA_ID,id)
        startActivity(intent)
    }

}