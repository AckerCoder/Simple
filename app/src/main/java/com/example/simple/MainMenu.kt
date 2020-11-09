package com.example.simple

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ListView
import android.widget.TextView
import com.example.simple.adapters.InventoryListAdapter
import com.example.simple.adapters.ProductListAdapter
import com.example.simple.classes.Product

var currentProduct:Product? = null

class MainMenu : AppCompatActivity() {
    fun addProductButton(view: View){
        val intent = Intent(applicationContext, NewProduct::class.java)
        startActivity(intent)
    }
    var adapterProductList: ProductListAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_menu)

        val inventoryTitle = findViewById<TextView>(R.id.inventoryTitle)
        inventoryTitle.text = currentInventory?.name


        val listViewProducts = findViewById<ListView>(R.id.productListView)
        adapterProductList = currentInventory?.products?.let { ProductListAdapter(this, it) }
        listViewProducts.adapter = adapterProductList
    }
}

