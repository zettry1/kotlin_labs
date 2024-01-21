package com.example.miu_mobile_assignemnt.database

import android.app.Application
import androidx.lifecycle.LiveData

class PlantRepository(application: Application) {
    private val plantDao: DBDao
    val allPlants: LiveData<List<PlantModel>>

    init {
        val database = MyDataBase.getMyDataBase(application)
        plantDao = database.dbDao()
        allPlants = plantDao.getAllPlants()
    }

    suspend fun insert(plant: PlantModel) {
        plantDao.insert(plant)
    }

    suspend fun update(plant: PlantModel) {
        plantDao.update(plant)
    }

    suspend fun delete(plant: PlantModel) {
        plantDao.delete(plant.id)
    }

    fun getPlantById(plantId: Int): LiveData<PlantModel> {
        return plantDao.getPlantById(plantId)
    }
}
