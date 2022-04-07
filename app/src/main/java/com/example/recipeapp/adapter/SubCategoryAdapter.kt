package com.example.recipeapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.recipeapp.R
import com.example.recipeapp.entities.MealsItem
import com.example.recipeapp.entities.Recipes

class SubCategoryAdapter: RecyclerView.Adapter<SubCategoryAdapter.RecipeViewHolder>() {

    var listener: SubCategoryAdapter.OnItemClickListener? =null
    var ctx: Context? = null
    var subCategory = ArrayList<MealsItem>()

    class RecipeViewHolder(view: View): RecyclerView.ViewHolder(view){
        val subNameText = itemView.findViewById<TextView>(R.id.tv_dish_name_sub)
        val subItemImage = itemView.findViewById<ImageView>(R.id.img_dish_sub)
    }

    fun setData(arrayData: ArrayList<MealsItem>){
        subCategory = arrayData as ArrayList<MealsItem>
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        return RecipeViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_rv_sub_category,parent,false))
    }

    fun setClickListener(listener1: SubCategoryAdapter.OnItemClickListener){
        listener = listener1
    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        holder.subNameText.text = subCategory[position].strMeal

        Glide.with(ctx!!).load(subCategory[position].strMeal).into(holder.subItemImage)

        holder.itemView.rootView.setOnClickListener {
            listener!!.onClicked(subCategory[position].idMeal)
        }
    }

    override fun getItemCount(): Int {
       return subCategory.size
    }
    interface OnItemClickListener{
        fun onClicked(id:String)
    }
}