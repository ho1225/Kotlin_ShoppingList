package com.example.shoppinglist.ui.shoppinglist

import android.content.Context
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatDialog
import com.example.shoppinglist.R
import com.example.shoppinglist.data.db.entities.ShoppingItem
//import kotlinx.android.synthetic.main.dialog_add_shopping_item.*

class AddShoppingItemDialog(context: Context, var addDialogListener: AddDialogListener) : AppCompatDialog(context) {

    private lateinit var tvAdd: TextView
    private lateinit var etName: EditText
    private lateinit var etAmount: EditText
    private lateinit var tvCancel: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_add_shopping_item)
        tvAdd = findViewById(R.id.tvAdd)!!
        etName = findViewById(R.id.etName)!!
        etAmount = findViewById(R.id.etAmount)!!
        tvCancel = findViewById(R.id.tvCancel)!!


        tvAdd.setOnClickListener {
            val name = etName.text.toString()
            val amount = etAmount.text.toString()

            if(name.isEmpty() || amount.isEmpty()) {
                Toast.makeText(context, "Please enter all the information", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val item = ShoppingItem(name, amount.toInt())
            addDialogListener.onAddButtonClicked(item)
            dismiss()
        }

        tvCancel.setOnClickListener {
            cancel()
        }
    }

}