package com.example.simplerecipesapp.repository

import androidx.annotation.WorkerThread
import com.example.simplerecipesapp.dao.CategoryDAO
import com.example.simplerecipesapp.model.RecipesCategory
import kotlinx.coroutines.flow.Flow

/**
 * Repository class for Category
 */
class CategoryRepository(private val categoryDAO: CategoryDAO) {

    val allCategories: Flow<List<RecipesCategory>> = categoryDAO.getCategories()

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(category: RecipesCategory) {
        categoryDAO.insert(category)
    }
}