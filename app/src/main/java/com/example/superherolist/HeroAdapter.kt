package com.example.superherolist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.superherolist.databinding.ItemSuperheroBinding

import com.squareup.picasso.Picasso
//import kotlinx.android.synthetic.main.item_superhero.* // Considera volver a agregar si la refactorización causa problemas

class HeroAdapter(private val superhero: List<SuperHero>)
    : RecyclerView.Adapter<HeroAdapter.HeroHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroHolder {

        val binding =
            ItemSuperheroBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return HeroHolder(binding)

    }

    override fun getItemCount(): Int = superhero.size

    override fun onBindViewHolder(holder: HeroHolder, position: Int) {
        holder.render(superhero[position])
    }

    inner class HeroHolder( private val binding: ItemSuperheroBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun render(superhero: SuperHero) {

            binding.tvSuperHeroName.text = superhero.superHeroName
            binding.tvPublisher.text = superhero.publisher
            Picasso.get().load(superhero.image).into(binding.ivHero)
        }
    }
}