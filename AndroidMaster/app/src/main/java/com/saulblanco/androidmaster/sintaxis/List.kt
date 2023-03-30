package com.saulblanco.androidmaster


fun inmutableList(){
    val readOnly:List<String> = listOf("Lunes","Martes","Miércoles","Jueves","Viernes","Sabado","Domingo")
    print(readOnly.size)

    //Esta función es lo mismo que readOnly.toString()
    print(readOnly)
    print(readOnly[0])

    //Da el último y el primer valor de la lista
    println(readOnly.last())
    println(readOnly.first())

    //Realizamos un filtro en la lista, donde "it" es cada una de las iteraciones
    val example = readOnly.filter { it.contains("a") }
    println(example)

    //Modificamos el it por el nombre que queramos
    //En este caso "weekDay"
    //readOnly.forEach{weekDay -> println(it)}

    readOnly.forEach{weekDay -> println(weekDay)}

}

fun mutableList() {
    //Así se inicializa una lista mutable sin valores o con valores
    val weekDays:MutableList<String> = mutableListOf("Lunes","Martes","Miércoles","Jueves","Viernes","Sabado","Domingo")

    //añadimos un valor a la lista
    weekDays.add("AkaDia")
    println(weekDays)

    weekDays.add(0,"Primer dia")
    println(weekDays)

    if(weekDays.isNotEmpty()){
        weekDays.forEach { println(it) }
    }
    weekDays.last()
}


fun main() {
    inmutableList()
    mutableList()

}

