package com.example.recipeapp.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.recipeapp.entities.Recipes

@Dao
interface RecipeDao {

    @get:Query("SELECT * FROM recipes ORDER BY id DESC")
    var allRecipes: List<Recipes>

    @Insert(onConflict =  OnConflictStrategy.REPLACE)
    fun insertRecipe(recipies: Recipes)
}