package com.saulblanco.androidmaster.superheroapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.saulblanco.androidmaster.R

class SuperheroAdapter(var superheroeList: List<SuperHeroeItemResponse> = emptyList(), private val onItemSelected:(String)->Unit) :
    RecyclerView.Adapter<SuperheroViewHolder>() {

    fun updateList(superheroeList: List<SuperHeroeItemResponse>){
        this.superheroeList=superheroeList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuperheroViewHolder {
        var layoutInflater = LayoutInflater.from(parent.context)
        return SuperheroViewHolder(layoutInflater.inflate(R.layout.item_superhero, parent, false))
    }


    override fun onBindViewHolder(viewholder: SuperheroViewHolder, position: Int) {
        viewholder.bind(superheroeList[position],onItemSelected)
    }


    override fun getItemCount() = superheroeList.size


}