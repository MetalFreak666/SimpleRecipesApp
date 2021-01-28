package com.example.simplerecipesapp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.simplerecipesapp.ui.adapters.RecipesCategoryAdapter
import com.example.simplerecipesapp.viewmodel.CategoryViewModel
import com.example.simplerecipesapp.viewmodel.CategoryViewModelFactory

class MainActivity : AppCompatActivity() {

    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, MainActivity::class.java).apply {
                flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            }
        }
    }

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