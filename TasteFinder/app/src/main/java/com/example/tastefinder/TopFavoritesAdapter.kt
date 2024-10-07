package com.example.tastefinder

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TopFavoritesAdapter(private val favoritesList: List<Restaurant>) :
    RecyclerView.Adapter<TopFavoritesAdapter.TopFavoritesViewHolder>() {

    class TopFavoritesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val restaurantName: TextView = itemView.findViewById(R.id.restaurant_name)
        val rating: TextView = itemView.findViewById(R.id.restaurant_rating)
        val restaurantImage: ImageView = itemView.findViewById(R.id.restaurant_image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopFavoritesViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_favorite, parent, false)
        return TopFavoritesViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: TopFavoritesViewHolder, position: Int) {
        val currentRestaurant = favoritesList[position]
        holder.restaurantName.text = currentRestaurant.name
        holder.rating.text = currentRestaurant.rating.toString()
        holder.restaurantImage.setImageResource(currentRestaurant.imageResId)
    }

    override fun getItemCount() = favoritesList.size
}