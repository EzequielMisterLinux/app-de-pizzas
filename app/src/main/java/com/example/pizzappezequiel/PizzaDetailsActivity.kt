package com.example.pizzappezequiel

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.ImageView
import android.widget.TextView

class PizzaDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pizza_details)

        val pizzaName = intent.getStringExtra("pizza_name")
        val pizzaPrice = intent.getFloatExtra("pizza_price", 0f)
        val pizzaImage = intent.getIntExtra("pizza_image", 0)

        val nameTextView: TextView = findViewById(R.id.pizza_name)
        val priceTextView: TextView = findViewById(R.id.pizza_price)
        val imageView: ImageView = findViewById(R.id.pizza_image)

        nameTextView.text = pizzaName
        priceTextView.text = String.format("$%.2f", pizzaPrice)
        imageView.setImageResource(pizzaImage)
    }
}
