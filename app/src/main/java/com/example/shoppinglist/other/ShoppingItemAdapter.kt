package com.example.shoppinglist.other

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.shoppinglist.R
import com.example.shoppinglist.data.db.entities.ShoppingItem
import com.example.shoppinglist.ui.shoppinglist.ShoppingViewModel

class ShoppingItemAdapter (
    var items: List<ShoppingItem>,
    private val viewModel: ShoppingViewModel
): RecyclerView.Adapter<ShoppingItemAdapter.ShoppingViewHolder>(){


    inner class ShoppingViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
    {
        var tvName: TextView = itemView.findViewById(R.id.tvName)
        var tvAmount: TextView = itemView.findViewById(R.id.tvAmount)
        var ivDelete: ImageView = itemView.findViewById(R.id.ivDelete)
        var ivPlus: ImageView = itemView.findViewById(R.id.ivPlus)
        var ivMinus: ImageView = itemView.findViewById(R.id.ivMinus)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.shopping_item, parent, false)
        return ShoppingViewHolder(view)
    }

    override fun onBindViewHolder(holder: ShoppingViewHolder, position: Int) {
        val curShoppingItem = items[position]

        holder.tvName.text = curShoppingItem.name
        holder.tvAmount.text = "${curShoppingItem.amount}"

        holder.ivDelete.setOnClickListener {
            viewModel.delete(curShoppingItem)
        }

        holder.ivPlus.setOnClickListener {
            curShoppingItem.amount++
            viewModel.upsert(curShoppingItem)
        }

        holder.ivMinus.setOnClickListener {
            if(curShoppingItem.amount > 0) {
                curShoppingItem.amount--
                viewModel.upsert(curShoppingItem)
            }
        }

    }

    override fun getItemCount(): Int {
        return items.size
    }

}