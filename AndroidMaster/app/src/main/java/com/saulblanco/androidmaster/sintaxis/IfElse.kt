package com.saulblanco.androidmaster

fun main() {
    ifBasico()
}

fun ifAnidado(){
    val animal="dog"
    if(animal == "dog"){
        println("Es un perro")
    }else if (animal == "cat"){
        println("Es un gato")
    }else if (animal=="bird"){
        println("Es un pájaro")
    }else{
        println("No es uno de los animales esperados")
    }
}

fun ifBasico(){
    val name = "Saul"
    if(name == "Saul"){
        println("Oye, la variable name es Saul")
    }else{
        println("Este no es Saúl")
    }

}