package com.example.simple.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.simple.R
import com.example.simple.classes.Section

class SectionListAdapter1(private val context: Context, private val dataSource: ArrayList<Section>): BaseAdapter() {
    private val inflater: LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getCount(): Int {
        return dataSource.size
    }

    override fun getItem(position: Int): Any {
        return dataSource[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val rowView = inflater.inflate(R.layout.inventory_list, parent, false)

        val sectionName = rowView.findViewById(R.id.sectionName) as TextView
        val sectionStock = rowView.findViewById(R.id.stockSection) as TextView

        val section = getItem(position) as Section

        sectionName.text = section.name
        sectionStock.text = section.stock.toString() + " " + section.units


        return rowView
    }
}