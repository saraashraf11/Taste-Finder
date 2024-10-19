package com.example.tastefinder

import FavoritesAdapter
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.widget.ProgressBar
import android.widget.TextView

class CategoryActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var emptyView: TextView
    private lateinit var progressBar: ProgressBar
    private lateinit var categoryAdapter: FavoritesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category)

        // Initialize views
        recyclerView = findViewById(R.id.recyclerView)
        emptyView = findViewById(R.id.emptyView)
        progressBar = findViewById(R.id.progressBar)

        // Set up RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(this)
        categoryAdapter = FavoritesAdapter(emptyList(), isCategory = true) // Start with empty list
        recyclerView.adapter = categoryAdapter

        // Load data (simulated)
        loadCategories()
    }

    private fun loadCategories() {
        progressBar.visibility = View.VISIBLE

        // Simulate a delay for loading categories
        recyclerView.postDelayed({
            val categories = getDummyCategories()

            progressBar.visibility = View.GONE
            if (categories.isEmpty()) {
                recyclerView.visibility = View.GONE
                emptyView.visibility = View.VISIBLE
            } else {
                recyclerView.visibility = View.VISIBLE
                emptyView.visibility = View.GONE
                categoryAdapter.updateCategories(categories) // Update the adapter with new data
            }
        }, 2000) // Simulate a 2-second delay
    }

    private fun getDummyCategories(): List<Restaurant> {
        // Replace with actual data fetching logic for categories
        return listOf(
//            Restaurant("Restaurant 1", 0, R.drawable.burger_image),
//            Restaurant("Restaurant 2", 0, R.drawable.pasta_image),
        )
    }
}
