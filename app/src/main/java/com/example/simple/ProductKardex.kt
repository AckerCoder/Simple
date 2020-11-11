package com.example.simple

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import android.widget.TextView

class ProductKardex : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_kardex)

        val title = findViewById<TextView>(R.id.productTitle)
        val sectionListView = findViewById<ListView>(R.id.sectionListView)


        title.text = currentProduct?.name

    }
}