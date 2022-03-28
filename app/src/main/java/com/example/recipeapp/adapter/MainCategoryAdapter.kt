package com.example.recipeapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recipeapp.R
import com.example.recipeapp.adapter.MainCategoryAdapter.*
import com.example.recipeapp.entities.Recipes

class MainCategoryAdapter: RecyclerView.Adapter<RecipeViewHolder>() {

    var mainCategory =ArrayList<Recipes>()
    class RecipeViewHolder (view: View):RecyclerView.ViewHolder(view){

        val nameText = itemView.findViewById<TextView>(R.id.tv_dish_name)


    }

    fun setData(arrayData : List<Recipes>){
        mainCategory = arrayData as ArrayList<Recipes>
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        return RecipeViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_rv_main_category,parent,false))
    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        holder.nameText.text = mainCategory[position].dishName
    }

    override fun getItemCount(): Int {
        return mainCategory.size
    }
}