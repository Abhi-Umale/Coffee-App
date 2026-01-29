package com.example.coffeeapp.presentation.screens.homescreen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.coffeeapp.domen.model.Product
import com.example.coffeeapp.presentation.navigation.Routs
import com.example.coffeeapp.presentation.theme.CharcoalGray
import com.example.coffeeapp.presentation.theme.CoffeeBrown
import com.example.coffeeapp.presentation.theme.CreamBeige
import com.example.coffeeapp.presentation.theme.IvoryWhite
import com.example.coffeeapp.presentation.theme.LightBrown
import com.example.coffeeapp.presentation.theme.LightGray

@Composable
fun ProductCard(
    product: Product,
    navController: NavController,
    modifier: Modifier = Modifier
) {

    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(6.dp),
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(12.dp),
        border = BorderStroke(2.dp, CreamBeige),
        onClick = {navController.navigate(Routs.DetailsScreen(product.id,product.price))}
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(160.dp)
                .padding(12.dp)
                .clip(RoundedCornerShape(13.dp)),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(product.image),
                contentDescription = "Card Image",
                contentScale = ContentScale.Crop
            )

            Box(
                modifier = Modifier
                    .width(50.dp)
                    .height(35.dp)
                    .padding(vertical = 4.dp, horizontal = 8.dp)
                    .align(Alignment.TopEnd)
                    .background(
                        color = LightGray.copy(alpha = 0.7f),
                        shape = RoundedCornerShape(6.dp)
                    ),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.FavoriteBorder,
                    contentDescription = "favorite",
                    tint = CoffeeBrown,
                    modifier = Modifier.size(30.dp)
                )
            }
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp)
        ) {
            Text(
                product.name,
                fontSize = 18.sp,
                fontWeight = FontWeight.ExtraBold,
                color = Color.Black,
                fontFamily = FontFamily.Serif,
                lineHeight = 4.sp
            )
            Text(
                product.description,
                fontSize = 16.sp,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                color = CharcoalGray,
                fontFamily = FontFamily.Serif
            )
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 6.dp, horizontal = 4.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    "$${product.price}",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = LightBrown
                )
                FloatingActionButton(
                    onClick = {},
                    modifier = Modifier
                        .size(40.dp)
                        .padding(2.dp)
                        .clip(shape = RoundedCornerShape(8.dp)),
                    shape = (RoundedCornerShape(12.dp)),
                    containerColor = CoffeeBrown,
                    contentColor = IvoryWhite
                ) {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = "Add Item",
                        Modifier
                            .size(20.dp)
                            .clickable(onClick = {navController.navigate(Routs.DetailsScreen(productId = product.id, productPrice = product.price))})
                    )
                }
            }
        }
    }
}