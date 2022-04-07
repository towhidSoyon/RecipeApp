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
import com.example.recipeapp.adapter.MainCategoryAdapter.*
import com.example.recipeapp.entities.CategoryItems

class MainCategoryAdapter: RecyclerView.Adapter<RecipeViewHolder>() {

    var listener: OnItemClickListener? =null
    var ctx: Context? = null
    var mainCategory =ArrayList<CategoryItems>()
    class RecipeViewHolder (view: View):RecyclerView.ViewHolder(view){

        val nameText = itemView.findViewById<TextView>(R.id.tv_dish_name)
        val itemIamge = itemView.findViewById<ImageView>(R.id.img_dish)


    }

    fun setData(arrayData : List<CategoryItems>){
        mainCategory = arrayData as ArrayList<CategoryItems>
    }

    fun setClickListener(listener1: OnItemClickListener){
        listener = listener1
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        ctx = parent.context
        return RecipeViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_rv_main_category,parent,false))
    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        holder.nameText.text = mainCategory[position].strCategory

        Glide.with(ctx!!).load(mainCategory[position].strCategoryThumb).into(holder.itemIamge)

        holder.itemView.rootView.setOnClickListener{
            listener!!.onClicked(mainCategory[position].strCategory)
        }
    }

    override fun getItemCount(): Int {
        return mainCategory.size
    }

    interface OnItemClickListener{
        fun onClicked(categoryName:String)
    }
}