package com.example.pizzappezequiel

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pizzappezequiel.adapters.SaladAdapter
import com.example.pizzappezequiel.models.Salad

class SaladsActivity : AppCompatActivity() {
    private lateinit var saladRecyclerView: RecyclerView
    private lateinit var saladAdapter: SaladAdapter

    private val saladList = listOf(
        Salad("Caesar Salad", 6.99, R.drawable.salad_caesar),
        Salad("Greek Salad", 7.99, R.drawable.salad_greek),
        Salad("Garden Salad", 5.99, R.drawable.salad_garden)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_salads)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Ensaladas"

        saladRecyclerView = findViewById(R.id.salad_recycler_view)
        saladRecyclerView.layoutManager = LinearLayoutManager(this)
        saladAdapter = SaladAdapter(saladList)
        saladRecyclerView.adapter = saladAdapter
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}