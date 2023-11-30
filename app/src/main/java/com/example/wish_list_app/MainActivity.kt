package com.example.wish_list_app

import android.os.Bundle
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.wish_list_app.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val items = mutableListOf<Item>()
    private lateinit var itemAdapter: ItemAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var btnAddItem: Button
    private lateinit var editTextItemName: EditText
    private lateinit var editTextItemPrice: EditText
    private lateinit var editTextItemURL: EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        itemAdapter = ItemAdapter(items)
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = itemAdapter
        btnAddItem = findViewById(R.id.btnAddItem)
        editTextItemName = findViewById(R.id.editTextItemName)
        editTextItemPrice = findViewById(R.id.editTextItemPrice)
        editTextItemURL = findViewById(R.id.editTextItemURL)


        btnAddItem.setOnClickListener {
            val itemName = editTextItemName.text.toString()
            val itemPrice = editTextItemPrice.text.toString()
            val itemURL = editTextItemURL.text.toString()

            if (itemName.isNotEmpty() && itemPrice.isNotEmpty() && itemURL.isNotEmpty()) {
                val newItem = Item(itemName, itemPrice, itemURL)
                items.add(newItem)
                itemAdapter.notifyDataSetChanged()

                // Clear input fields
                editTextItemName.text.clear()
                editTextItemPrice.text.clear()
                editTextItemURL.text.clear()
            }
        }
    }
}