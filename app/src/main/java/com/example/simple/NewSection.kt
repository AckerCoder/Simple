package com.example.simple

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.simple.classes.Inventory
import com.example.simple.classes.Section
import com.google.gson.Gson

class NewSection : AppCompatActivity() {

    fun addNewSectionButton(view: View){
        val sectionName = findViewById<EditText>(R.id.addSectionName).text.toString()
        val sectionUnits = findViewById<EditText>(R.id.addSectionUnits).text.toString()
        val newSection = Section(sectionName, 0, sectionUnits)
        currentProduct?.addSection(newSection)

        inventoriesList[currentInventoryPosition!!].products[currentProductPosition!!].addSection(newSection)

        val sharedPreferences = getSharedPreferences("Data", Context.MODE_PRIVATE)

        val editor = sharedPreferences.edit()
        val gson = Gson();
        val json = gson.toJson(inventoriesList)
        editor.putString("inventories",json)
        editor.apply()

        val intent = Intent(applicationContext, ProductKardex::class.java)
        startActivity(intent)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_section)

        val title = findViewById<TextView>(R.id.productTitle2)
        title.setText(currentProduct?.name)
        Toast.makeText(this, inventoriesList[currentInventoryPosition!!].products[currentProductPosition!!].sections?.get(0)?.name,Toast.LENGTH_LONG)
    }
}