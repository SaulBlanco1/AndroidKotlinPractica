package com.saulblanco.androidmaster

var age: Int = 18

fun main() {

    variablesNumericas()
    variablesBoolean()
    variablesAlfanumericas()
    showMyAge()
    add(13, 23)

    val mySubtract= subtract(10,5)
    println(mySubtract)
}

//La función recibe la edad y si no recibe nada, tiene una edad por defecto
fun showMyAge(currentAge: Int = 20) {
    println("Tengo $currentAge anhos")
}

fun add(firstNumber: Int, secondNumber: Int) {
    println(firstNumber + secondNumber)
}

//Función que recibe dos parámetros de entrada
// y tiene un parámetro de salida
fun subtract(firstNumber: Int, secondNumber: Int):Int {
    var resul:Int=(firstNumber - secondNumber)
    return resul
    //Después del return no se ejecuta el código
    print("adios")
}

//Función de manera abreviada, le indicamos que lo devuelto
//es un Int pero no haría falta
fun subtractCool(firstNumber: Int,secondNumber: Int):Int =firstNumber-secondNumber


fun variablesBoolean() {

    val booleanExample: Boolean = true
    val booleanExample2 = false

}

fun variablesAlfanumericas() {
    //Variables Alfanuméricas
    //Char
    val charExample: Char = '2'
    val charExample2: Char = 'p'
    val charExample3: Char = '+'

    //String
    val name = "Saul Blanco"
    val stringExample: String = "Esto es una string"
    val stringExample2 = "Esto es una string"
    val stringExample3 = "4"
    val stringExample4 = "23"

    //Sumar String = Append
    print("Resul: " + stringExample3 + stringExample4)

    var stringConcatenado: String = "Hola"
    println(stringConcatenado)
    stringConcatenado = "Hola me llamo $stringExample2 y tengo $age"
    println(stringConcatenado)
    val example123: String = age.toString()
}

fun variablesNumericas() {
    //Variables Numéricas


    //Long
    val numLong: Long = 12121

    //Float
    val floatExample: Float = 30.5f

    //Double
    val doubleExample: Double = 323.232323



    println(age + numLong)
    //Conversión de float a Int
    var exampleSuma: Int = age + floatExample.toInt()

    println("Sumar: ")
    println(age + 2)

    println("Restar: ")
    println(age - 2)

    println("Multiplicar")
    println(age * 2)

    println("División")
    println(age / 2)

    println("Módulo")
    println(age % 2)

}