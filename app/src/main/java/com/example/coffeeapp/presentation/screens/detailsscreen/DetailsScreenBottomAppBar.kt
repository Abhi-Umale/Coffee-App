package com.example.coffeeapp.presentation.screens.detailsscreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import com.example.coffeeapp.domen.model.Product
import com.example.coffeeapp.presentation.navigation.Routs
import com.example.coffeeapp.presentation.theme.CoffeeBrown
import com.example.coffeeapp.presentation.theme.CreamBeige
import com.example.coffeeapp.presentation.theme.IvoryWhite
import com.example.coffeeapp.presentation.ui_component.AppMessageDialog

@Composable
fun DetailsScreenBottomAppBar(product: Product,navController: NavController) {

    var showCartDialog by remember { mutableStateOf(false) }

    BottomAppBar(
        containerColor = CreamBeige.copy(0.5f),
        contentColor = Color.Black,
        modifier = Modifier.height(130.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                Modifier
                    .weight(0.3f)
                    .padding(8.dp)
            ) {
                Text(
                    "Price",
                    color = Color.DarkGray,
                    fontSize = 18.sp
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text("$ ${product.price}",
                    fontSize = 22.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = CoffeeBrown
                )
            }

            Button(
                onClick = {
                    navController.navigate(Routs.CartScreen)
                    showCartDialog = true },
                modifier = Modifier
                    .weight(0.7f)
                    .size(60.dp)
                    .padding(horizontal = 20.dp),
                colors = ButtonDefaults.buttonColors(
                    contentColor = IvoryWhite,
                    containerColor = CoffeeBrown
                ),
                shape = RoundedCornerShape(10.dp)
            ) {
                Text(
                    "Add to cart",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Black
                )
            }

            AppMessageDialog(
                show = showCartDialog,
                title = "Add to Cart",
                message = "Item has been Added to your cart.",
                onDismiss = { showCartDialog = false }
            )

        }
    }
}