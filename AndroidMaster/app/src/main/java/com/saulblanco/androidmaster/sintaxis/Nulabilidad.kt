package com.saulblanco.androidmaster

fun main() {
    //Variable que puede ser nula necesita el simbolo "?"
    var name:String? =null

    //Si name no es nulo que de el valor
    //usando (elvis) "?:" indicamos lo que hacer
    //en caso de ser nulo
    println(name?.get(2) ?: "Sí que es nulo")

    //Aseguras que name no es nulo
    println(name!![0])
}