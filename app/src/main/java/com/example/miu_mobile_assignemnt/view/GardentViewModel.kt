package com.example.miu_mobile_assignemnt.view


import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.miu_mobile_assignemnt.database.MyDataBase
import com.example.miu_mobile_assignemnt.database.PlantModel
import com.example.miu_mobile_assignemnt.database.PlantRepository
import kotlinx.coroutines.launch


class GardenViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: PlantRepository

    val allPlants: LiveData<List<PlantModel>>

    init {

         val myData =MyDataBase.getMyDataBase(application).dbDao()
        repository = PlantRepository(application)
        allPlants = repository.allPlants
    }

    fun insert(plant: PlantModel) = viewModelScope.launch {
        repository.insert(plant)
    }

    fun update(plant: PlantModel) = viewModelScope.launch {
        repository.update(plant)
    }

    fun delete(plant: PlantModel) = viewModelScope.launch {
        repository.delete(plant)
    }

    fun getPlantById(plantId: Int): LiveData<PlantModel> = viewModelScope.run {
        repository.getPlantById(plantId)
    }
}