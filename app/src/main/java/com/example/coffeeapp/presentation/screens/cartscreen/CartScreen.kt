package com.example.coffeeapp.presentation.screens.cartscreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.coffeeapp.R
import com.example.coffeeapp.domen.model.Product
import com.example.coffeeapp.presentation.theme.LightBrown
import com.example.coffeeapp.presentation.ui_component.MyBottomNavBar
import com.example.coffeeapp.presentation.ui_component.MyTopAppBar

@Composable
fun CartScreen(navController: NavController) {

    val cardProducts = listOf(
        Product(1, "Espresso", "Strong and rich ", 3.80, R.drawable.coffee_1),
        Product(2, "Latte", "Smooth and creamy ", 4.50, R.drawable.coffee_2),
        Product(3, "Cappuccino", "With Chocolate", 4.20, R.drawable.coffee_3),
    )

    Scaffold(
        topBar = { MyTopAppBar("Details",navController) },
        bottomBar = { MyBottomNavBar(navController,"Cart") }
    ) {innerPadding ->

        var price by remember { mutableStateOf(cardProducts.sumOf { it.price }) }
        var deliveryFee by remember { mutableStateOf(1.0) }
        var totalPrice by remember { mutableStateOf(price + deliveryFee) }

        LazyColumn(modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)
        ){

            item{

                Row {
                    Text("Deliver",
                        fontSize = 28.sp,
                        fontWeight = FontWeight.Bold,
                        color = LightBrown,
                        modifier = Modifier.padding(10.dp)
                    )
                }

                cardProducts.forEach { product ->
                    CartItemCard(product)
                }

                Spacer(modifier = Modifier.height(20.dp))
                Text("Payment Service",
                    modifier = Modifier
                        .padding(horizontal = 15.dp, vertical = 10.dp),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
                Row(modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 15.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text("Price",
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 18.sp,
                        color = Color.DarkGray
                    )
                    Text("$ $price",
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                        color = Color.DarkGray
                    )
                }

                Row(modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 15.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text("Delivery Fee",
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 18.sp,
                        color = Color.DarkGray
                    )
                    Text("$ $deliveryFee",
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                        color = Color.DarkGray
                    )
                }
                Spacer(modifier = Modifier.height(20.dp))

                PaymentCard(totalPrice = totalPrice)
            }
        }
    }
}