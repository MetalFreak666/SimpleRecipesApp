package com.example.simplerecipesapp.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "categories_table")
class RecipesCategory(@PrimaryKey @ColumnInfo(name = "category")
    val category: String
    )