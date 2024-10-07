package com.example.tastefinder

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.navigation.NavigationView

class HomeActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var topFavoritesRecyclerView: RecyclerView
    private lateinit var categoriesRecyclerView: RecyclerView
    private lateinit var drawerLayout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)

        // إعداد الـ DrawerLayout
        drawerLayout = findViewById(R.id.drawer_layout)

        // إعداد الـ Toolbar
        val toolbar: androidx.appcompat.widget.Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        // ActionBarDrawerToggle للتحكم في فتح وإغلاق القائمة
        val toggle = ActionBarDrawerToggle(
            this,
            drawerLayout,
            toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        // إعداد NavigationView
        val navigationView: NavigationView = findViewById(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener(this)

        // إعداد RecyclerView لأفضل المطاعم
        topFavoritesRecyclerView = findViewById(R.id.rv_top_favorites)
        topFavoritesRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        topFavoritesRecyclerView.adapter = TopFavoritesAdapter(getTopFavorites())

        // إعداد RecyclerView للفئات
        categoriesRecyclerView = findViewById(R.id.rv_categories)
        categoriesRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        categoriesRecyclerView.adapter = CategoriesAdapter(getCategories())
    }

    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_home -> {
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
            }
            R.id.nav_favorites -> {
                val intent = Intent(this, FavoritesFragment::class.java)
                startActivity(intent)
            }
            R.id.nav_search -> {
                val intent = Intent(this, SearchFragment::class.java)
                startActivity(intent)
            }
            R.id.nav_location -> {
                val intent = Intent(this, LocationFragment::class.java)
                startActivity(intent)
            }
        }
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

    private fun getTopFavorites(): List<Restaurant> {
        // قائمة المطاعم المفضلة
        return listOf(
            Restaurant("Crinkle", 50, R.drawable.image_logo_crinkle),
            Restaurant("Burgista", 30, R.drawable.image_logo_burgsta),
            // إضافة المطاعم الأخرى هنا...
        )
    }

    private fun getCategories(): List<Category> {
        // قائمة الفئات
        return listOf(
            Category("Burgers", R.drawable.burger_image),
            Category("Pasta", R.drawable.pasta_image),
            // إضافة فئات أخرى هنا...
        )
    }
}