package com.example.simple

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import com.example.simple.classes.Product
import com.google.gson.Gson

class NewProduct : AppCompatActivity() {
    var productName:String? = null
    fun addProductButton(view: View){
        productName?.let { Product(it) }?.let {
            inventoriesList[currentInventoryPosition!!].addProduct(
                it
            )
        }

        val sharedPreferences = getSharedPreferences("Data", Context.MODE_PRIVATE)

        val editor = sharedPreferences.edit()
        val gson = Gson();
        val json = gson.toJson(inventoriesList)
        editor.putString("inventories",json)
        editor.apply()

        val intent = Intent(applicationContext, MainMenu::class.java)
        startActivity(intent)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_product)
        productName = findViewById<EditText>(R.id.addProductName).text.toString()
    }
}