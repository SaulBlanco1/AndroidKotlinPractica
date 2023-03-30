package com.saulblanco.androidmaster

fun main() {
    var name:String = "Saul"

    val weekDays=arrayOf("Lunes","Martes","Miércoles","Jueves","Viernes","Sabado","Domingo")

    println(weekDays[0])

    //BUCLES PARA ARRAY

    //Nos indica la posición deseada
    for(position in weekDays.indices){
        println(weekDays[position])
    }

    //Nos indica la posición y el valor de la misma
    for((position,value) in weekDays.withIndex()){
        println("La posición $position contiene $value")
    }

    //Nos indica los valores
    for(diaSemana in weekDays){
        println(diaSemana)
    }
}