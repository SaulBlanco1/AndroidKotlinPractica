package com.saulblanco.androidmaster

fun main() {
    getMonth(2)
    getSemester(1)
    getTrimester(3)
}

fun result(value:Any){
    when(value){
        is Int ->value + value
        is String -> println(value)
        is Boolean ->if(value) println("Hola")
    }
}

fun getMonth(month:Int){
    when(month){
        1->println("Enero")
        2->println("Febrero")
        3->println("Marzo")
        4->println("Abril")
        5->println("Mayo")
        6->println("Junio")
        7->println("Julio")
        8->println("Agosto")
        9->println("Septiembre")
        10->println("Octubre")
        11->{
            println("Noviembre")
            println("Noviembre")
        }
        12->println("Diciembre")
        else -> println("No es un mes válido")
    }
}
fun getSemester(month:Int):String{
    return when(month){
        in 1..6->"Primer semestre"
        in 7..12->"Segundo semestre"
        !in 1..12->"Semestre no válido"
        else ->"ERROR"
    }

}

fun getTrimester(month:Int){
    when(month){
        1,2,3->println("Primer trimestre")
        4,5,6->println("Segundo trimestre")
        7,8,9->println("Tercer trimestre")
        10,11,12->println("Cuatro trimestre")
        else->println("Trimestre no válido")
    }
}