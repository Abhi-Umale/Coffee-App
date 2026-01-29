package com.example.coffeeapp.presentation.screens.favouritescreens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.coffeeapp.R
import com.example.coffeeapp.domen.model.Product
import com.example.coffeeapp.presentation.ui_component.MyBottomNavBar
import com.example.coffeeapp.presentation.ui_component.MyTopAppBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FavouriteScreen(navController: NavController) {

    var favouriteItem by remember {
        mutableStateOf(
            listOf(
                Product(3, "Cappuccino", "With Chocolate", 4.20, R.drawable.coffee_3),
                Product(4, "Mocha", "with cocoa flavor", 4.70, R.drawable.coffee_4),
                Product(4, "Macchiato", "Bold and milky", 4.60, R.drawable.coffee_5),
                Product(6, "Flat White", "Velvety smooth", 4.40, R.drawable.coffee_6)
            )

        )
    }
    Scaffold(
        topBar = { MyTopAppBar("Wishlist", navController) },
        bottomBar = { MyBottomNavBar(navController, "Favourites") }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {
                Column(
                    modifier = Modifier
                        .padding(vertical = 20.dp)
                        .fillMaxWidth()
                ) {
                    favouriteItem.forEach { product ->
                        FavouriteCard(
                            product,
                            onRemove = { favouriteItem = favouriteItem - product }
                        )
                    }
                }
            }
        }
    }
}