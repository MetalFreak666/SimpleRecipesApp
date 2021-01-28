package com.example.simplerecipesapp.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.simplerecipesapp.dao.CategoryDAO
import com.example.simplerecipesapp.model.RecipesCategory
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

/**
 * Room database component for categories
 */
@Database(entities = arrayOf(RecipesCategory::class), version = 1, exportSchema = false)
abstract class CategoryRoomDB: RoomDatabase() {

    abstract fun categoryDao(): CategoryDAO

    private class CategoryDatabaseCallback(private val scope: CoroutineScope): RoomDatabase.Callback() {
        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            INSTANCE?.let { database ->
                scope.launch {
                    var categoryDao = database.categoryDao()

                    //Delete content
                    categoryDao.deleteAll()

                    //Adding categories
                    var category = RecipesCategory("Vegetarian Recipes")
                    categoryDao.insert(category)
                    category = RecipesCategory("Meat Lovers")
                    categoryDao.insert(category)
                }
            }
        }
    }

    companion object {
        @Volatile
        private var INSTANCE: CategoryRoomDB? = null

        fun getDatabase(context: Context, scope: CoroutineScope): CategoryRoomDB {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    CategoryRoomDB::class.java,
                    "category_database"
                ).addCallback(CategoryDatabaseCallback(scope))
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}