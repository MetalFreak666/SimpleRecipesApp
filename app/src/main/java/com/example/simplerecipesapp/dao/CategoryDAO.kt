package com.example.simplerecipesapp.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.simplerecipesapp.model.RecipesCategory
import kotlinx.coroutines.flow.Flow

@Dao
interface CategoryDAO {
    @Query("SELECT * FROM categories_table ORDER BY category ASC")
    fun getCategories(): Flow<List<RecipesCategory>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(category: RecipesCategory)

    @Query("DELETE FROM categories_table")
    suspend fun deleteAll()
}