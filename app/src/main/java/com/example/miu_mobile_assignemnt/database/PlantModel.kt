package com.example.miu_mobile_assignemnt.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "plant")
data class PlantModel(
    @PrimaryKey(autoGenerate = true) var id: Int = 0,
    @ColumnInfo(name = "name") var name: String,
    @ColumnInfo(name = "type") var type: String,
    @ColumnInfo(name = "wateringFrequency") var wateringFrequency: Int,
    @ColumnInfo(name = "plantingDate") var plantingDate: String
)
