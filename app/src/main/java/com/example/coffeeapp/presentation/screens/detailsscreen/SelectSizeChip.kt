package com.example.coffeeapp.presentation.screens.detailsscreen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.coffeeapp.presentation.theme.CharcoalGray
import com.example.coffeeapp.presentation.theme.LightBrown

@Preview(showBackground = true)
@Composable
fun SelectSizeChip() {

    val sizes = listOf("S", "M", "L")
    var selectedSize by remember { mutableStateOf("S") }


    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        sizes.forEach { size ->

            val isSelected = selectedSize == size

            Box(
                modifier = Modifier
                    .weight(1f)
                    .padding(8.dp)
                    .background(
                        color = Color.White,
                        shape = RoundedCornerShape(10.dp)
                    )
                    .border(
                        width = 3.dp,
                        color = if (isSelected) LightBrown else Color.Transparent,
                        shape = RoundedCornerShape(12.dp)
                    )
                    .clickable { selectedSize = size },
                contentAlignment = Alignment.Center
            ) {
                Text(
                    size,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = if (isSelected) LightBrown else CharcoalGray,
                    modifier = Modifier.padding(10.dp)
                )
            }

        }

    }

}