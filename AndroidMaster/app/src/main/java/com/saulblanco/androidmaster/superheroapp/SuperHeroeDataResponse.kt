package com.saulblanco.androidmaster.superheroapp

import com.google.gson.annotations.SerializedName

//"response" tiene que llamarse igual que en el JSON
//Siempre poner el serializedname
data class SuperHeroeDataResponse(
    @SerializedName("response") val isWorking: String,
    @SerializedName("results") val superheroes: List<SuperHeroeItemResponse>
){


}

//Se crea una clase con la respuesta de todos los atributos del superheroe
data class SuperHeroeItemResponse(
    @SerializedName("id") val superheroId: String,
    @SerializedName("name") val name: String,
    @SerializedName("image") val superheroImage: SuperheroImageResponse

)

data class SuperheroImageResponse(@SerializedName("url") val url: String)