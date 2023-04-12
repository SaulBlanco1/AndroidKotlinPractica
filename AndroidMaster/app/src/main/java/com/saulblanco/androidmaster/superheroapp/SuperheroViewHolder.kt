package com.saulblanco.androidmaster.superheroapp

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.saulblanco.androidmaster.databinding.ItemSuperheroBinding
import com.squareup.picasso.Picasso

class SuperheroViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding = ItemSuperheroBinding.bind(view)

    fun bind(superHeroeItemResponse: SuperHeroeItemResponse, onItemSelected:(String)->Unit) {
        binding.tvSuperheroName.text = superHeroeItemResponse.name
        Picasso.get().load(superHeroeItemResponse.superheroImage.url).into(binding.ivSuperHero)
        binding.root.setOnClickListener{onItemSelected(superHeroeItemResponse.superheroId)}

    }
}