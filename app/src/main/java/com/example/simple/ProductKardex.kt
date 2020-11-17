package com.example.simple

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ListView
import android.widget.TextView

class ProductKardex : AppCompatActivity() {
    fun addSecctionButton(view: View){
        val intent = Intent(applicationContext, NewSection::class.java)
        startActivity(intent)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_kardex)

        val title = findViewById<TextView>(R.id.productTitle)
        val sectionListView = findViewById<ListView>(R.id.sectionListView1)


        title.text = currentProduct?.name

    }
}