package com.example.simple.classes
import com.example.simple.NewSection
import com.example.simple.classes.Section as Section

class Product {
    var name: String
    var sections = ArrayList<Section>()

    constructor(name: String){
        this.name = name
    }

    fun addSection(newSection: Section){
        sections.add(newSection)
    }

}