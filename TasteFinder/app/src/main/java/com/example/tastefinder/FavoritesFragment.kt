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
            // You can add click logic here if needed
        }
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = favoritesAdapter

        // Load the data (simulated)
        loadFavorites()

        return view
    }

    private fun loadFavorites() {
        // Show the progress bar while loading data
        progressBar.visibility = View.VISIBLE

        // Simulating data loading with a delay
        recyclerView.postDelayed({
            // Add items to the list
            favoriteItems.addAll(
                listOf(
//                    Restaurant("Restaurant 1", 10, R.drawable.google_svgrepo_com),
//                    Restaurant("Restaurant 2", 6, R.drawable.facebook_color_svgrepo_com),
//                    Restaurant("Restaurant 3", 9, R.drawable.heart_svgrepo_com)
                )
            )

            // Hide the progress bar
            progressBar.visibility = View.GONE

            // Update the UI after loading data
            updateUI()
        }, 2000) // 2-second delay to simulate loading
    }

    private fun updateUI() {
        if (favoriteItems.isEmpty()) {
            // Show empty view if no data is available
            emptyView.visibility = View.VISIBLE
            recyclerView.visibility = View.GONE
        } else {
            // Show RecyclerView if data is available
            emptyView.visibility = View.GONE
            recyclerView.visibility = View.VISIBLE
            favoritesAdapter.notifyDataSetChanged()
        }
    }
}
