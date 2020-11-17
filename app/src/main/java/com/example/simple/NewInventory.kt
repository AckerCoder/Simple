package com.example.simple

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import com.example.simple.classes.Inventory
import com.google.gson.Gson

class NewInventory : AppCompatActivity() {


    fun addNewInventoryButton(view: View){
        val inventoryName = findViewById<EditText>(R.id.addSectionName).text.toString()
        val inventoryLocation = findViewById<EditText>(R.id.addSectionUnits).text.toString()
        val newInventory = Inventory(inventoryName, inventoryLocation)
        inventoriesList.add(newInventory)

        val sharedPreferences = getSharedPreferences("Data", Context.MODE_PRIVATE)

        val editor = sharedPreferences.edit()
        val gson = Gson();
        val json = gson.toJson(inventoriesList)
        editor.putString("inventories",json)
        editor.apply()

        val intent = Intent(applicationContext, MainActivity::class.java)
        startActivity(intent)
    }

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nuevo_inventario)
    }
}

