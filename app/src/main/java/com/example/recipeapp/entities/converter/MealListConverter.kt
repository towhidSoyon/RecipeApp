package com.example.recipeapp.entities.converter

import androidx.room.TypeConverter
import com.example.recipeapp.entities.Category
import com.example.recipeapp.entities.MealsItem
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class MealListConverter {
    @TypeConverter
    fun fromCategoryList(category: List<MealsItem>):String?{
        if (category == null){
            return (null)
        }else{
            val gson = Gson()
            val type = object : TypeToken<MealsItem>(){

            }.type
            return gson.toJson(category,type)
        }
    }

    fun toCategoryList (categoryString: String):List<MealsItem>?{
        if (categoryString == null){
            return (null)
        } else {
            val gson = Gson()
            val type = object : TypeToken<MealsItem>(){

            }.type
            return gson.fromJson(categoryString, type)

        }
    }
}