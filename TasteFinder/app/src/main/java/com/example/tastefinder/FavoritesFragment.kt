package com.example.tastefinder

import FavoritesAdapter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class FavoritesFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var emptyView: TextView
    private lateinit var progressBar: ProgressBar

    private lateinit var favoritesAdapter: FavoritesAdapter
    private val favoriteItems = mutableListOf<Restaurant>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_favorites, container, false)

        // Initialize views
        recyclerView = view.findViewById(R.id.recyclerView)
        emptyView = view.findViewById(R.id.emptyView)
        progressBar = view.findViewById(R.id.progressBar)

        // Set up RecyclerView and Adapter
        favoritesAdapter = FavoritesAdapter(favoriteItems) { restaurant ->
            // Handle favorite icon click
        }
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = favoritesAdapter

        // Load the data (simulated)
        loadFavorites()

        return view
    }

    private fun loadFavorites() {
        progressBar.visibility = View.VISIBLE

        // Simulate data loading
        recyclerView.postDelayed({
            favoriteItems.addAll(
                listOf(
//                    Restaurant("Restaurant 1", 10, R.drawable.google_svgrepo_com),
//                    Restaurant("Restaurant 2", 6, R.drawable.facebook_color_svgrepo_com),
//                    Restaurant("Restaurant 3", 9, R.drawable.heart_svgrepo_com)
                )
            )

            progressBar.visibility = View.GONE
            updateUI()
        }, 2000) // 2-second delay
    }

    private fun updateUI() {
        if (favoriteItems.isEmpty()) {
            emptyView.visibility = View.VISIBLE
            recyclerView.visibility = View.GONE
        } else {
            emptyView.visibility = View.GONE
            recyclerView.visibility = View.VISIBLE
            favoritesAdapter.notifyDataSetChanged()
        }
    }
}