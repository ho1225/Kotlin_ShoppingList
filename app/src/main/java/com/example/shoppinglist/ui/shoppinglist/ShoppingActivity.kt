package com.example.shoppinglist.ui.shoppinglist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.shoppinglist.R
import com.example.shoppinglist.data.db.ShoppingDatabase
import com.example.shoppinglist.data.db.entities.ShoppingItem
import com.example.shoppinglist.data.repositories.ShoppingRepository
import com.example.shoppinglist.other.ShoppingItemAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton

//import kotlinx.android.synthetic.main.activity_shopping.*

class ShoppingActivity : AppCompatActivity() {
    private lateinit var rvShoppingItems: RecyclerView
    private lateinit var fab:  FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping)

        rvShoppingItems = findViewById(R.id.rvShoppingItems)
        fab = findViewById(R.id.fab)


        val database = ShoppingDatabase(this)
        val repository = ShoppingRepository(database)
        val factory = ShoppingViewModelFactory(repository)

        val viewModel = ViewModelProviders.of(this, factory).get(ShoppingViewModel::class.java)

        val adapter = ShoppingItemAdapter(listOf(), viewModel)

        rvShoppingItems.layoutManager = LinearLayoutManager(this)
        rvShoppingItems.adapter = adapter

        viewModel.getAllShoppingItems().observe(this, Observer {
            adapter.items = it
            adapter.notifyDataSetChanged()
        })

        fab.setOnClickListener {
            AddShoppingItemDialog(this,
                object: AddDialogListener{
                    override fun onAddButtonClicked(item: ShoppingItem) {
                        viewModel.upsert(item)
                    }
                }).show()
        }
    }
}