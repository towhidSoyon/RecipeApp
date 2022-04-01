package com.example.recipeapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.Toast
import com.example.recipeapp.entities.Category
import com.example.recipeapp.interfaces.GetDataService
import com.example.recipeapp.retrofitclient.RetrofitClientInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class SplashActivity : BaseActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val buttonGetStarted = findViewById<Button>(R.id.buttonGetStarted)


        buttonGetStarted.setOnClickListener{
            var intent = Intent(this@SplashActivity, HomeActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    fun getCategories() {
        val service = RetrofitClientInstance.retrofitClientInstance!!.create(GetDataService::class.java)
        val call = service.getCategoryList()
        call.enqueue(object : Callback<Category> {
            override fun onFailure(call: Call<Category>, t: Throwable) {

                Toast.makeText(this@SplashActivity, "Something went wrong", Toast.LENGTH_SHORT)
                    .show()
            }

            override fun onResponse(
                call: Call<Category>,
                response: Response<Category>
            ) {

                insertDataIntoRoomDb(response.body())
            }

        })
    }


    fun insertDataIntoRoomDb(category: Category?){

    }
}








