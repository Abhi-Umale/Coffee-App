package com.example.coffeeapp.presentation.screens.profilescreen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.WbSunny
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.coffeeapp.presentation.navigation.Routs
import com.example.coffeeapp.presentation.theme.CoffeeBrown

@Composable
fun ProfileScreenCard(navController: NavController) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
                .clickable(onClick = {navController.navigate(Routs.CartScreen)}),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Icon(
                imageVector = Icons.Default.ShoppingCart,
                contentDescription = "Cart Icon",
                tint = CoffeeBrown,
                modifier = Modifier
                    .padding( 10.dp)
                    .size(30.dp)
            )
            Spacer(modifier = Modifier.width(25.dp))
            Text(
                "Orders",
                fontWeight = FontWeight.Bold,
                fontSize = 22.sp
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
                .clickable(onClick = {navController.navigate(Routs.FavouritesScreen)}),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Icon(
                imageVector = Icons.Default.Favorite,
                contentDescription = "Favourite",
                tint = CoffeeBrown,
                modifier = Modifier
                    .padding( 10.dp)
                    .size(30.dp)
            )
            Spacer(modifier = Modifier.width(25.dp))
            Text(
                "Favourite",
                fontWeight = FontWeight.Bold,
                fontSize = 22.sp
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
                .clickable(onClick = {}),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Icon(
                imageVector = Icons.Default.WbSunny,
                contentDescription = "Change Theme",
                tint = CoffeeBrown,
                modifier = Modifier
                    .padding( 10.dp)
                    .size(30.dp)
            )
            Spacer(modifier = Modifier.width(25.dp))
            Text(
                "Theame",
                fontWeight = FontWeight.Bold,
                fontSize = 22.sp
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
                .clickable(onClick = {}),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Icon(
                imageVector = Icons.Default.Settings,
                contentDescription = "Setings",
                tint = CoffeeBrown,
                modifier = Modifier
                    .padding(10.dp)
                    .size(30.dp)
            )
            Spacer(modifier = Modifier.width(25.dp))
            Text(
                "Setting",
                fontWeight = FontWeight.Bold,
                fontSize = 22.sp
            )
        }
    }

}