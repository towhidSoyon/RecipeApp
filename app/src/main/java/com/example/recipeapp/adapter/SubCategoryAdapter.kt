package com.example.recipeapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recipeapp.R
import com.example.recipeapp.entities.Recipes

class SubCategoryAdapter: RecyclerView.Adapter<SubCategoryAdapter.RecipeViewHolder>() {

    var subCategory = ArrayList<Recipes>()

    class RecipeViewHolder(view: View): RecyclerView.ViewHolder(view){
        val subNameText = itemView.findViewById<TextView>(R.id.tv_dish_name_sub)
    }

    fun setData(arrayData : List<Recipes>){
        subCategory = arrayData as ArrayList<Recipes>
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        return RecipeViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_rv_sub_category,parent,false))
    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        holder.subNameText.text = subCategory[position].dishName
    }

    override fun getItemCount(): Int {
       return subCategory.size
    }
}