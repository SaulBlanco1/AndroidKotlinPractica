package com.saulblanco.androidmaster.todoapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.saulblanco.androidmaster.R

class CategoriesAdapter(private val categories:List<TaskCategory>, private val onItemSelected:(Int)->Unit):RecyclerView.Adapter<CategoriesViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriesViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.item_task_category,parent,false)
        return CategoriesViewHolder(view)

    }

    override fun onBindViewHolder(holder: CategoriesViewHolder, position: Int) {
        //Otra manera de enviar una función LAMBDA
        holder.render(categories[position],onItemSelected)

    }

    //Función que devuelve el número de categorias (modo abreviado)
    override fun getItemCount()= categories.size




}