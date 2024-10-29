package com.example.pizzappezequiel.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.pizzappezequiel.R
import com.example.pizzappezequiel.models.Salad

class SaladAdapter(
    private val saladList: List<Salad>
) : RecyclerView.Adapter<SaladAdapter.SaladViewHolder>() {

    class SaladViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val saladImage: ImageView = itemView.findViewById(R.id.salad_image)
        val saladName: TextView = itemView.findViewById(R.id.salad_name)
        val saladPrice: TextView = itemView.findViewById(R.id.salad_price)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SaladViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_salad, parent, false)
        return SaladViewHolder(view)
    }

    override fun onBindViewHolder(holder: SaladViewHolder, position: Int) {
        val salad = saladList[position]
        holder.saladImage.setImageResource(salad.imageResourceId)
        holder.saladName.text = salad.name
        holder.saladPrice.text = String.format("$%.2f", salad.price)
    }

    override fun getItemCount(): Int = saladList.size
}
