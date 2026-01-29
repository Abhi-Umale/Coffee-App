package com.example.coffeeapp.presentation.screens.detailsscreen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.coffeeapp.R
import com.example.coffeeapp.domen.model.Product
import com.example.coffeeapp.presentation.theme.CharcoalGray
import com.example.coffeeapp.presentation.theme.LightBrown

@Composable
fun DetailsScreen(productId: Int,productPrice : Double, navController: NavController) {

    val products = listOf(
        Product(1, "Espresso", "Strong and rich ", 3.80, R.drawable.coffee_1),
        Product(2, "Latte", "Smooth and creamy ", 4.50, R.drawable.coffee_2),
        Product(3, "Cappuccino", "With Chocolate", 4.20, R.drawable.coffee_3),
        Product(4, "Mocha", "with cocoa flavor", 4.70, R.drawable.coffee_4),
        Product(4, "Macchiato", "Bold and milky", 4.60, R.drawable.coffee_5),
        Product(6, "Flat White", "Velvety smooth", 4.40, R.drawable.coffee_6),
        Product(7, "Iced Mocha", "Refreshing and rich", 4.70, R.drawable.coffee_2),
        Product(8, "Iced Latte", "Smooth and creamy", 4.50, R.drawable.coffee_1)
    )

    val selectedProduct = products.find { it.id == productId }
    val selectedPrice = products.find { it.price == productPrice }


    if (selectedProduct == null || selectedPrice == null ){
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text("Product not found!",
                fontSize = 26.sp,
                fontWeight = FontWeight.Bold,
                color = LightBrown,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(25.dp))
            Button(
                onClick = {navController.navigateUp() },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent,
                    contentColor = LightBrown
                ),
                border = BorderStroke(2.dp, CharcoalGray.copy(0.7f)),
                shape = RoundedCornerShape(10.dp)
            ) {
                Text("Go Back",
                    fontSize = 26.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )
            }
        }

        return
    }

    Scaffold(
        topBar = {DetailsScreenTopAppBar(navController)},
        bottomBar = {DetailsScreenBottomAppBar(selectedPrice, navController)}
    ) {innerPadding ->

        LazyColumn {
            item {

                ProductDetailsContent(
                    selectedProduct,
                    innerPadding
                )

            }
        }

    }

}