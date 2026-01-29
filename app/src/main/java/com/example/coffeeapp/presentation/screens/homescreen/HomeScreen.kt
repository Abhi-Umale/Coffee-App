package com.example.coffeeapp.presentation.screens.homescreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.coffeeapp.R
import com.example.coffeeapp.domen.model.Product
import com.example.coffeeapp.presentation.ui_component.MyBottomNavBar

@Composable
fun HomeScreen(navController: NavController) {

    val location = "Badnera Rd, Amravati"
    Scaffold(
        bottomBar = { MyBottomNavBar(navController,"Home") }
    ) { innerPadding ->

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(1f / 3f)
                .background(
                    brush = Brush.linearGradient(
                        colors = listOf(
                            Color(0xFF303030),
                            Color(0xFF1F1F1F),
                            Color(0xFF121212)
                        )
                    )
                )
        )

        Column(
            modifier = Modifier.padding(innerPadding)
        ) {

            Text(
                "Location",
                modifier = Modifier
                    .padding(top = 15.dp, start = 20.dp),
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                fontFamily = FontFamily.Serif,
                color = Color.Gray
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 3.dp, start = 20.dp),
                horizontalArrangement = Arrangement.spacedBy(4.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = location,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    fontFamily = FontFamily.Serif,
                    color = Color.White
                )
                Icon(
                    imageVector = Icons.Default.KeyboardArrowDown,
                    contentDescription = "KeyboardArrowDown",
                    tint = Color.Gray
                )
            }
            //Displaying Product
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

            ProductsGrid(products = products, navController) {

                Spacer(modifier = Modifier.height(35.dp))
                //SearchBar
                MySearchBar()
                Spacer(modifier = Modifier.height(20.dp))

                Image(
                    painter = painterResource(R.drawable.banner_1),
                    contentDescription = "Banner",
                    modifier = Modifier.padding(vertical = 10.dp, horizontal = 20.dp)
                )

                HomeScreenCategories()

            }

        }
    }
}