package com.example.miu_mobile_assignemnt.view


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.miu_mobile_assignemnt.R


import android.annotation.SuppressLint
import androidx.recyclerview.widget.DiffUtil
import com.example.miu_mobile_assignemnt.database.PlantModel


class PlantAdapter(private val onClick: (PlantModel) -> Unit) :
    androidx.recyclerview.widget.ListAdapter<PlantModel, PlantAdapter.PlantViewHolder>(PlantDiffCallback) {


    class PlantViewHolder(itemView: View, val onClick: (PlantModel) -> Unit) :
        RecyclerView.ViewHolder(itemView) {
        private var currentPlant: PlantModel? = null
        val name: TextView = itemView.findViewById(R.id.name)
        init {
            itemView.setOnClickListener {
                currentPlant?.let {
                    onClick(it)
                }
            }
        }

        /* Bind plant name and image. */
        @SuppressLint("SetTextI18n")
        fun bind(plant: PlantModel) {
            currentPlant = plant
            name.text = plant.name
        }

        private fun adapterOnClick(ingredient: String) {

        }
    }

    /* Creates and inflates view and return PlantViewHolder. */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlantViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.one_plant, parent, false)
        return PlantViewHolder(view, onClick)
    }

    /* Gets current plant and uses it to bind view. */
    override fun onBindViewHolder(holder: PlantViewHolder, position: Int) {
        val plant = getItem(position)
        holder.bind(plant)
    }
}

object PlantDiffCallback : DiffUtil.ItemCallback<PlantModel>() {
    override fun areItemsTheSame(oldItem: PlantModel, newItem: PlantModel): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: PlantModel, newItem: PlantModel): Boolean {
        return oldItem.id == newItem.id
    }
}