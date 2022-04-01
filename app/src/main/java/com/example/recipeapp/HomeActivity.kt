package com.example.recipeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recipeapp.adapter.MainCategoryAdapter
import com.example.recipeapp.adapter.SubCategoryAdapter
import com.example.recipeapp.entities.Recipes

class HomeActivity : BaseActivity() {

    var mainCategory = ArrayList<Recipes>()
    var subCategory = ArrayList<Recipes>()

    var mainCategoryAdapter = MainCategoryAdapter()
    var subCategoryAdapter = SubCategoryAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val rv_main_category = findViewById<RecyclerView>(R.id.rv_main_category)
        val rv_sub_category = findViewById<RecyclerView>(R.id.rv_sub_category)

        mainCategory.add(Recipes(1,"Beef"))
        mainCategory.add(Recipes(2,"Chicken"))
        mainCategory.add(Recipes(3,"Desert"))
        mainCategory.add(Recipes(4,"Lamb"))

        mainCategoryAdapter.setData(mainCategory)


        subCategory.add(Recipes(1,"Beef and mustard pie"))
        subCategory.add(Recipes(2,"Chicken and Mushroom hotpot"))
        subCategory.add(Recipes(3,"Banana pancakes"))
        subCategory.add(Recipes(4,"Kapsalon"))

        subCategoryAdapter.setData(subCategory)

        rv_main_category.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        rv_main_category.adapter = mainCategoryAdapter

        rv_sub_category.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        rv_sub_category.adapter = subCategoryAdapter
    }
}