package com.saulblanco.androidmaster.todoapp

//Aprovechamos la sealed class para poner un atributo que tienen todos los objetos en comun
//en este caso, isSelected
sealed class TaskCategory (var isSelected:Boolean = true){
    object Personal :TaskCategory()
    object Business :TaskCategory()
    object Other :TaskCategory()

}