package com.example.coffeeapp.presentation.screens.cartscreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.HorizontalRule
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.coffeeapp.R
import com.example.coffeeapp.domen.model.Product
import com.example.coffeeapp.presentation.theme.CharcoalGray
import com.example.coffeeapp.presentation.theme.IvoryWhite
import com.example.coffeeapp.presentation.theme.LightBrown
import com.example.coffeeapp.presentation.theme.PurpleGrey80

@Composable
fun  CartItemCard(product: Product) {

    var count by remember { mutableStateOf(1) }
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp)
            .padding(vertical = 8.dp, horizontal = 10.dp)
            .background(CharcoalGray.copy(0.1f)),
        elevation = CardDefaults.cardElevation(10.dp),
        shape = RoundedCornerShape(16.dp)
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(PurpleGrey80.copy(0.1f)),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Image(
                painter = painterResource(product.image),
                contentDescription = "Card Image",
                modifier = Modifier
                    .padding(vertical = 8.dp, horizontal = 10.dp)
                    .size(90.dp)
                    .background(
                        color = Color.Transparent,
                        shape = RoundedCornerShape(10.dp)
                    )
                    .clip(shape = RoundedCornerShape(10.dp)),
                contentScale = ContentScale.Crop
            )

            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(horizontal = 10.dp),
                verticalArrangement = Arrangement.Center,
            ) {
                Text(
                    product.name,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    product.description,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.DarkGray
                )
            }
            Spacer(modifier = Modifier.weight(1f))
            Row(
                modifier = Modifier
                    .padding(4.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.HorizontalRule,
                    contentDescription = "Subtract",
                    modifier = Modifier
                        .height(30.dp)
                        .width(45.dp)
                        .padding(horizontal = 8.dp)
                        .background(IvoryWhite, RoundedCornerShape(100))
                        .clickable(onClick = {if (count > 1 ) count--}),
                    tint = LightBrown
                )
                Text(
                    count.toString(),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Add",
                    modifier = Modifier
                        .height(30.dp)
                        .width(45.dp)
                        .padding(horizontal = 8.dp)
                        .background(IvoryWhite, RoundedCornerShape(100))
                        .clickable(onClick = {count++}),
                    tint = LightBrown
                )
            }
        }
    }
}