package com.example.coffeeapp.presentation.screens.homescreen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.coffeeapp.presentation.theme.IvoryWhite
import com.example.coffeeapp.presentation.theme.LightBrown

@Composable
fun CategoryChip(
    text: String,
    isSelected: Boolean,
    onSelected: () -> Unit
) {

    Card(
        modifier = Modifier
            .padding(top = 14.dp, start = 6.dp, end = 6.dp)
            .wrapContentSize()
            .clickable { onSelected() },
        colors = CardDefaults.cardColors(
            contentColor = Color.Black,
            containerColor = (if (isSelected) LightBrown else IvoryWhite)
        ),
        shape = RoundedCornerShape(6.dp),
        elevation = CardDefaults.cardElevation(10.dp)
    ) {
        Text(text = text,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(8.dp)
        )
    }

}