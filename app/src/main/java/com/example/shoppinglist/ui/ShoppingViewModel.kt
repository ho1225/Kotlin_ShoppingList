package com.example.shoppinglist.ui

import androidx.lifecycle.ViewModel
import com.example.shoppinglist.data.repositories.ShoppingRepository

class ShoppingViewModel(
    private val repository: ShoppingRepository
): ViewModel() {
}