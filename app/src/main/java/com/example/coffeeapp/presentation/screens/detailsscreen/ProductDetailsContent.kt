package com.example.coffeeapp.presentation.screens.detailsscreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.coffeeapp.R
import com.example.coffeeapp.domen.model.Product
import com.example.coffeeapp.presentation.theme.CharcoalGray
import com.example.coffeeapp.presentation.theme.CreamBeige
import com.example.coffeeapp.presentation.theme.LightBrown
@Composable
fun ProductDetailsContent(product: Product,innerPadding: PaddingValues) {

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(innerPadding)
        .background(color = CreamBeige.copy(0.5f))
    ) {

        Image(painter = painterResource(product.image),
            contentDescription = "Image",
            modifier = Modifier
                .fillMaxWidth()
                .padding(18.dp)
                .height(265.dp)
                .shadow(18.dp,RoundedCornerShape(12.dp))
                .clip(RoundedCornerShape(20.dp)),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(product.name,
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(horizontal = 20.dp)
        )
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text("Ice / Hot",
                fontSize = 18.sp,
                fontWeight = FontWeight.Black,
                color = CharcoalGray.copy(0.7f))
            Icon(painter = painterResource(R.drawable.default_bean),
                contentDescription = "bean logo",
                tint = LightBrown
            )
        }
        HorizontalDivider(
            thickness = 2.dp,
            color = CharcoalGray.copy(0.1f),
            modifier = Modifier.padding(20.dp))

        Text("Description",
            fontSize = 24.sp,
            fontWeight = FontWeight.SemiBold,
            color = CharcoalGray,
            modifier = Modifier.padding(vertical = 15.dp, horizontal = 20.dp)
        )
        Text(product.description,
            fontSize = 20.sp,
            fontWeight = FontWeight.Black,
            color = CharcoalGray.copy(0.7f),
            modifier = Modifier.padding(horizontal = 20.dp)
        )

        HorizontalDivider(
            thickness = 2.dp,
            color = CharcoalGray.copy(0.1f),
            modifier = Modifier.padding(20.dp)
        )

        Text("Size",
            fontSize = 24.sp,
            fontWeight = FontWeight.SemiBold,
            color = CharcoalGray,
            modifier = Modifier.padding(vertical = 10.dp, horizontal = 20.dp)
        )
        SelectSizeChip()
        Spacer(modifier = Modifier.height(60.dp))

    }

}