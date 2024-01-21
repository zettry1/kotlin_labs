package com.example.miu_mobile_assignemnt.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.miu_mobile_assignemnt.R
import com.example.miu_mobile_assignemnt.database.PlantModel

import com.example.miu_mobile_assignemnt.databinding.FragmentPlantBinding


class PlantFragment : Fragment() {
    private var plantId: Int = 0
    private var _binding: FragmentPlantBinding? = null


    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val plantViewModel =
            ViewModelProvider(this).get(GardenViewModel::class.java)

        _binding = FragmentPlantBinding.inflate(inflater, container, false)
        val root: View = binding.root

        plantId = arguments?.getInt("plantId") ?: 0
        plantViewModel.getPlantById(plantId).observe(viewLifecycleOwner) {
            displayPlantDetails(it)
        }

        return root
    }

    @SuppressLint("SetTextI18n")
    private fun displayPlantDetails(plant: PlantModel) {
        view?.findViewById<TextView>(R.id.name)?.text = plant.name
        view?.findViewById<TextView>(R.id.type)?.text = "Type: ${plant.type}"
        view?.findViewById<TextView>(R.id.wateringFrequency)?.text = "WateringFrequency: ${plant.wateringFrequency} days"
        view?.findViewById<TextView>(R.id.plantingDate)?.text = "Planting Date:${plant.plantingDate}"
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}