package com.example.pizzappezequiel

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pizzappezequiel.adapters.PizzaAdapter
import com.example.pizzappezequiel.models.Pizza

class FavoritesActivity : AppCompatActivity() {
    private lateinit var favoritesRecyclerView: RecyclerView
    private lateinit var pizzaAdapter: PizzaAdapter

    private val favoritesList = listOf(
        Pizza("Margherita", 8.99, R.drawable.pizza_margherita),
        Pizza("Pepperoni", 9.99, R.drawable.pizza_pepperoni)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favorites)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Favoritos"

        favoritesRecyclerView = findViewById(R.id.favorites_recycler_view)
        favoritesRecyclerView.layoutManager = LinearLayoutManager(this)
        pizzaAdapter = PizzaAdapter(favoritesList) { /* No click listener needed */ }
        favoritesRecyclerView.adapter = pizzaAdapter
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
