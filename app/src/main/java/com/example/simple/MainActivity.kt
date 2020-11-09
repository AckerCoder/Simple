package com.example.simple

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ListView
import android.widget.Toast
import com.example.simple.adapters.InventoryListAdapter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type
import com.example.simple.classes.Inventory as Inventory

var inventoriesList = ArrayList<Inventory>()
var currentInventory:Inventory? = null
var currentInventoryPosition:Int? = null

class MainActivity : AppCompatActivity() {
    private lateinit var inventoryListView: ListView
    var adapterInventoryList: InventoryListAdapter? = null

    fun addInventoryButton(view: View) {
        val intent = Intent(applicationContext, NewInventory::class.java)
        startActivity(intent)
    }

    fun loadArrayInventories() {
            val sharedPreferences = getSharedPreferences("Data", Context.MODE_PRIVATE)
        if(sharedPreferences.contains("inventories")){
            val gson = Gson()
            val json = sharedPreferences.getString("inventories", null)
            val type = object : TypeToken<ArrayList<Inventory>>() {}.type
            inventoriesList = gson.fromJson(json, type)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadArrayInventories()

        inventoryListView = findViewById(R.id.productListView)

        adapterInventoryList = InventoryListAdapter(this, inventoriesList)
        inventoryListView.divider = null
        inventoryListView.dividerHeight = 0
        inventoryListView.adapter = adapterInventoryList

        inventoryListView.setOnItemClickListener { _, _, position, _ ->
            currentInventory = inventoriesList[position]
            currentInventoryPosition = position
            val intent = Intent(applicationContext, MainMenu::class.java)
            startActivity(intent)
        }

    }
}