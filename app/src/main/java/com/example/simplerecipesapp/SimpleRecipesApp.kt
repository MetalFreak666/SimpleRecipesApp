package com.example.simplerecipesapp

import android.app.Application
import com.example.simplerecipesapp.repository.CategoryRepository
import com.example.simplerecipesapp.room.CategoryRoomDB
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class SimpleRecipesApp: Application() {

    private val applicationScope = CoroutineScope(SupervisorJob())
    private val database by lazy { CategoryRoomDB.getDatabase(this, applicationScope) }
    val repository by lazy { CategoryRepository(database.categoryDao()) }
}