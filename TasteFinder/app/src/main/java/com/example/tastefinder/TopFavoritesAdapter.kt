package com.example.tastefinder

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TopFavoritesAdapter(private val restaurants: List<Restaurant>) : RecyclerView.Adapter<TopFavoritesAdapter.FavoriteViewHolder>() {

    class FavoriteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val restaurantImage: ImageView = itemView.findViewById(R.id.iv_restaurant_image)
        val restaurantName: TextView = itemView.findViewById(R.id.tv_restaurant_name)
        val favoriteCount: TextView = itemView.findViewById(R.id.tv_favorite_count)
        val favoriteIcon: ImageView = itemView.findViewById(R.id.iv_favorite_icon)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_favorite, parent, false)
        return FavoriteViewHolder(view)
    }

    override fun onBindViewHolder(holder: FavoriteViewHolder, position: Int) {
        val restaurant = restaurants[position]
        holder.restaurantName.text = restaurant.name
        holder.favoriteCount.text = restaurant.likes.toString()

        // تحميل صورة المطعم من المصادر
        holder.restaurantImage.setImageResource(restaurant.imageResource)
    }

    override fun getItemCount(): Int {
        return restaurants.size
    }
}