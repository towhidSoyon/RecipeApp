package com.example.recipeapp.database

import android.content.Context
import androidx.room.*
import com.example.recipeapp.dao.RecipeDao
import com.example.recipeapp.entities.*
import com.example.recipeapp.entities.converter.CategoryListConverter
import com.example.recipeapp.entities.converter.MealListConverter

@Database(entities = [Recipes::class, CategoryItems::class, Category::class, CategoryListConverter::class,Meal::class, MealsItem::class], version = 1, exportSchema = false)
@TypeConverters(CategoryListConverter::class, MealListConverter::class)
abstract class RecipeDatabase : RoomDatabase(){
    companion object{

        var recipesDatabase:RecipeDatabase ? = null

        @Synchronized
        fun getDatabase(context: Context): RecipeDatabase{
            if (recipesDatabase == null){
                recipesDatabase = Room.databaseBuilder(
                    context,
                    RecipeDatabase::class.java,
                    "recipe.db"
                ).build()
            }
            return recipesDatabase!!
        }
    }
    abstract fun recipeDao():RecipeDao
}