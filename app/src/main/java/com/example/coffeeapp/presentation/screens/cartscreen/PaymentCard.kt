package com.example.coffeeapp.presentation.screens.cartscreen

import androidx.compose.foundation.BorderStroke
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.coffeeapp.R
import com.example.coffeeapp.presentation.theme.CoffeeBrown
import com.example.coffeeapp.presentation.theme.CreamBeige
import com.example.coffeeapp.presentation.theme.IvoryWhite
import com.example.coffeeapp.presentation.theme.LightBrown

@Composable
fun PaymentCard(totalPrice: Double) {

    var selectedMode by remember { mutableStateOf("Online") }
    var expanded by remember { mutableStateOf(false) }
    val paymentModes = listOf("Online", "Cash")

    Card(
        modifier = Modifier
            .padding(horizontal = 10.dp)
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(16.dp),
        shape = RoundedCornerShape(16.dp),
    ) {
        Row(
            modifier = Modifier
                .padding(30.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Icon(
                painter = painterResource(
                        if (selectedMode == "Online")R.drawable.mobile_banking
                    else R.drawable.wallet
                ),
                contentDescription = "Phone",
                tint = LightBrown,
                modifier = Modifier
                    .size(70.dp)
                    .padding(vertical = 20.dp, horizontal = 12.dp)
            )
            Column {
                Text(
                    selectedMode,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.padding(2.dp))
                if (selectedMode == "Online") {
                    Text(
                        "$ $totalPrice",
                        color = LightBrown,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )
                } else{
                    Text(
                        "$ ${totalPrice + 1}",
                        color = LightBrown,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
            Spacer(modifier = Modifier.weight(1f))
            Box(modifier = Modifier.padding(10.dp)) {
                Icon(
                    painter = painterResource(R.drawable.regular_outline_arrow_down),
                    contentDescription = "DownArrow",
                    tint = Color.DarkGray,
                    modifier = Modifier
                        .padding(10.dp)
                        .clickable(onClick = {expanded = true})
                )
                DropdownMenu(
                    expanded = expanded,
                    onDismissRequest = {expanded = false}
                ) {

                    paymentModes.forEach { mode ->
                        DropdownMenuItem(
                            text = {
                                Text(mode,
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.Bold,
                                    modifier = Modifier.padding(vertical = 8.dp, horizontal = 20.dp)
                                )
                            },
                            onClick = {
                                selectedMode = mode
                                expanded = false
                            },
                            leadingIcon = {
                                Icon(painter = painterResource(
                                    if (mode == "Online") R.drawable.mobile_banking
                                    else R.drawable.wallet
                                ),
                                    contentDescription = "Phone",
                                    tint = LightBrown,
                                    modifier = Modifier.size(30.dp)
                                )
                            },
                            modifier = Modifier.background(
                                if (selectedMode == mode) LightBrown.copy(0.2f) else Color.Transparent
                            )
                        )
                    }
                }
            }
        }
        Button(
            onClick = {},
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp, bottom = 20.dp, top = 10.dp)
                .height(54.dp),
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = CoffeeBrown,
                contentColor = IvoryWhite
            ),
            elevation = ButtonDefaults.buttonElevation(
                defaultElevation = 5.dp,
                pressedElevation = 10.dp
            ),
            border = BorderStroke(1.dp, CreamBeige)
        ) {
            Text(
                "PLACE ORDER",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }

}