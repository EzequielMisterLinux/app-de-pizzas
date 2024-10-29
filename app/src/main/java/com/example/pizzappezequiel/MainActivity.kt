package com.example.pizzappezequiel

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pizzappezequiel.adapters.PizzaAdapter
import com.example.pizzappezequiel.models.Pizza
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var pizzaRecyclerView: RecyclerView
    private lateinit var pizzaAdapter: PizzaAdapter

    private val pizzaList = listOf(
        Pizza("Margherita", 8.99, R.drawable.pizza_margherita),
        Pizza("Pepperoni", 9.99, R.drawable.pizza_pepperoni),
        Pizza("Hawaiian", 10.99, R.drawable.pizza_veggie)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Setup RecyclerView
        setupRecyclerView()

        // Setup Bottom Navigation
        setupBottomNavigation()
    }

    private fun setupRecyclerView() {
        pizzaRecyclerView = findViewById(R.id.recycler_view)
        pizzaRecyclerView.layoutManager = LinearLayoutManager(this)
        pizzaAdapter = PizzaAdapter(pizzaList) { pizza ->
            openPizzaDetails(pizza)
        }
        pizzaRecyclerView.adapter = pizzaAdapter
    }

    private fun setupBottomNavigation() {
        val bottomNav: BottomNavigationView = findViewById(R.id.bottom_navigation)
        bottomNav.setOnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.nav_menu -> true
                R.id.nav_favorites -> {
                    openFavorites()
                    true
                }
                R.id.nav_salads -> {
                    openSalads()
                    true
                }
                else -> false
            }
        }
    }

    // Options Menu methods
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.top_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_search -> {
                // Implement search functionality
                true
            }
            R.id.action_settings -> {
                // Implement settings functionality
                true
            }
            R.id.action_cart -> {
                // Implement cart functionality
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    // Navigation methods
    private fun openPizzaDetails(pizza: Pizza) {
        val intent = Intent(this, PizzaDetailsActivity::class.java)
        intent.putExtra("pizza_name", pizza.name)
        intent.putExtra("pizza_price", pizza.price)
        intent.putExtra("pizza_image", pizza.imageResourceId)
        startActivity(intent)
    }

    private fun openFavorites() {
        startActivity(Intent(this, FavoritesActivity::class.java))
    }

    private fun openSalads() {
        startActivity(Intent(this, SaladsActivity::class.java))
    }
}