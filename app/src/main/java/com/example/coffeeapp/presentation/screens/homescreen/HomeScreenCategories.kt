package com.example.coffeeapp.presentation.screens.homescreen

import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier

@Composable
fun HomeScreenCategories() {

    val categories = listOf("All Coffee", "Macchiato", "Latte", "Americano", "Snacks", "Desserts")

    var selectedCategory by remember { mutableStateOf(categories.first()) }

    LazyRow {
        items(categories) { category ->
            CategoryChip(
                text = category,
                isSelected = category == selectedCategory,
                onSelected = {
                    selectedCategory = category
                }
            )
        }
    }

}