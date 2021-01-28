package com.example.simplerecipesapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.simplerecipesapp.ui.adapters.RecipesCategoryAdapter

class MainActivity : AppCompatActivity() {

    private val categoryViewModel: CategoryViewModel by viewModels {
        CategoryViewModelFactory((application as SimpleRecipesApp).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Init of recyclerView
        val recyclerView = findViewById<RecyclerView>(R.id.categories_recycler)
        val adapter = RecipesCategoryAdapter()
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        categoryViewModel.allCategories.observe(this) { categories ->
            categories.let { adapter.submitList(it) }
        }
    }
}