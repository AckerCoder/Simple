package com.example.simple.classes
import com.example.simple.classes.Product as Product

class Inventory {
    var name: String
    var location: String
    var products = ArrayList<Product>()

    constructor(name: String, location: String){
        this.name = name
        this.location = location
    }

    fun addProduct(newProduct:Product){
        products.add(newProduct)
    }
}