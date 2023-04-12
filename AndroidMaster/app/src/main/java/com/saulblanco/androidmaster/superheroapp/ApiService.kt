package com.saulblanco.androidmaster.superheroapp

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.Response

interface ApiService {

    //Para usar corrutinas empieza siempre por "SUSPEND"
    @GET("/api/108440468890674/search/{name}")
    suspend fun getSuperheroes(@Path("name") superheroesName:String): Response<SuperHeroeDataResponse>

    @GET("/api/108440468890674/{id}")
    suspend fun getSuperheroDetail(@Path("id") superheroId:String): Response<SuperHeroDetailResponse>


}