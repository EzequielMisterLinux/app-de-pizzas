package com.example.pizzappezequiel.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.pizzappezequiel.R
import com.example.pizzappezequiel.models.Pizza

class PizzaAdapter(
    private val pizzaList: List<Pizza>,
    private val onClick: (Pizza) -> Unit
) : RecyclerView.Adapter<PizzaAdapter.PizzaViewHolder>() {

    class PizzaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val pizzaImage: ImageView = itemView.findViewById(R.id.pizza_image)
        val pizzaName: TextView = itemView.findViewById(R.id.pizza_name)
        val pizzaPrice: TextView = itemView.findViewById(R.id.pizza_price)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PizzaViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_pizza, parent, false)
        return PizzaViewHolder(view)
    }

    override fun onBindViewHolder(holder: PizzaViewHolder, position: Int) {
        val pizza = pizzaList[position]
        holder.pizzaImage.setImageResource(pizza.imageResourceId)
        holder.pizzaName.text = pizza.name
        holder.pizzaPrice.text = String.format("$%.2f", pizza.price)

        holder.itemView.setOnClickListener {
            onClick(pizza)
        }
    }

    override fun getItemCount(): Int {
        return pizzaList.size
    }
}
