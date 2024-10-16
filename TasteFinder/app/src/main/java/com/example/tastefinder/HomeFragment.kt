package com.example.tastefinder

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        // إعداد RecyclerView لأفضل المطاعم
        val topFavoritesRecyclerView = view.findViewById<RecyclerView>(R.id.rv_top_favorites)
        topFavoritesRecyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        topFavoritesRecyclerView.adapter = TopFavoritesAdapter(getTopFavorites())

        // إعداد RecyclerView للفئات
        val categoriesRecyclerView = view.findViewById<RecyclerView>(R.id.rv_categories)
        categoriesRecyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        categoriesRecyclerView.adapter = CategoriesAdapter(getCategories())

        return view
    }

    private fun getTopFavorites(): List<Restaurant> {
        // قائمة المطاعم المفضلة
        return listOf(
            Restaurant("Crinkle", 50, R.drawable.image_logo_crinkle),
            Restaurant("Burgista", 30, R.drawable.image_logo_burgsta)
            // إضافة المزيد من المطاعم
        )
    }

    private fun getCategories(): List<Category> {
        // قائمة الفئات
        return listOf(
            Category("Burgers", R.drawable.burger_image),
            Category("Pasta", R.drawable.pasta_image)
            // إضافة فئات أخرى
        )
    }
}
