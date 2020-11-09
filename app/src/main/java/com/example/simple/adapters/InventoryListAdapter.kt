package com.example.simple.adapters

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import androidx.cardview.widget.CardView
import com.example.simple.classes.Inventory
import com.example.simple.R

class InventoryListAdapter(private val context: Context, private val dataSource: ArrayList<Inventory>): BaseAdapter() {
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

        val inventoryName = rowView.findViewById(R.id.inventoryName) as TextView
        val inventoryLocation = rowView.findViewById(R.id.inventoryLocation) as TextView
        val cardView = rowView.findViewById(R.id.cardViewInventory) as CardView

        val inventory = getItem(position) as Inventory

        inventoryName.text = inventory.name
        inventoryLocation.text = inventory.location

        if(position%2 != 0){
            cardView.setCardBackgroundColor(Color.parseColor("#000000"))
            inventoryName.setTextColor(Color.parseColor("#FFFFFF"))
            inventoryLocation.setTextColor(Color.parseColor("#FFFFFF"))
        }
        return rowView
    }
}