package com.example.miu_mobile_assignemnt.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface DBDao {
    @Query("SELECT * FROM plant")
    fun getAllPlants(): LiveData<List<PlantModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(plant: PlantModel)
    @Query("DELETE FROM plant WHERE id = :plantId")
    suspend fun delete(plantId: Int)
    @Query("SELECT * FROM plant WHERE id = :plantId")
    fun getPlantById(plantId: Int): LiveData<PlantModel>

    @Update
    suspend fun update(plant: PlantModel)
    @Query("DELETE FROM plant")
    suspend fun deleteAll()

}