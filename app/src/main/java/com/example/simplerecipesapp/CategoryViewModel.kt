package com.example.simplerecipesapp

import androidx.lifecycle.*
import com.example.simplerecipesapp.model.RecipesCategory
import kotlinx.coroutines.launch
import java.lang.IllegalArgumentException

class CategoryViewModel(private val repository: CategoryRepository): ViewModel() {

    val allCategories: LiveData<List<RecipesCategory>> = repository.allCategories.asLiveData()

    fun insert(category: RecipesCategory) = viewModelScope.launch {
        repository.insert(category)
    }
}

class CategoryViewModelFactory(private val repository: CategoryRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(CategoryViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return CategoryViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown view model class")
    }
}