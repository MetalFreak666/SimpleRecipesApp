package com.example.simplerecipesapp.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.simplerecipesapp.R
import com.example.simplerecipesapp.model.RecipesCategory

class RecipesCategoryAdapter: ListAdapter<RecipesCategory, RecipesCategoryAdapter.CategoriesViewHolder>(CategoriesComparator()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriesViewHolder {
        return CategoriesViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: CategoriesViewHolder, position: Int) {
        val current = getItem(position)
        holder.bind(current.category)
    }

    class CategoriesViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        private val categoryItemView: TextView = itemView.findViewById(R.id.category_title)

        fun bind(text: String?) {
            categoryItemView.text = text
        }

        companion object {
            fun create(parent: ViewGroup): CategoriesViewHolder {
                val view: View = LayoutInflater.from(parent.context).inflate(R.layout.category_item, parent, false)
                return CategoriesViewHolder(view)
            }
        }
    }

    class CategoriesComparator: DiffUtil.ItemCallback<RecipesCategory>() {
        override fun areItemsTheSame(oldItem: RecipesCategory, newItem: RecipesCategory): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: RecipesCategory, newItem: RecipesCategory): Boolean {
            return oldItem.category == newItem.category
        }
    }
}