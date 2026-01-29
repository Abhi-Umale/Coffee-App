package com.example.coffeeapp.presentation.ui_component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.coffeeapp.R
import com.example.coffeeapp.presentation.navigation.Routs
import com.example.coffeeapp.presentation.theme.CharcoalGray
import com.example.coffeeapp.presentation.theme.LightBrown

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopAppBar(title: String, navController: NavController) {

    TopAppBar(
        title = {
            Text(
                title,
                fontSize = 26.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.fillMaxWidth().padding(end = 50.dp),
                textAlign = TextAlign.Center,
                color = CharcoalGray
            )
        },
        navigationIcon = {
            IconButton(
                onClick = {
                    navController.navigateUp()
                    navController.popBackStack(
                        route = Routs.HomeScreen,
                        inclusive = false
                    )
                },
                modifier = Modifier.padding(horizontal = 8.dp),
                colors = IconButtonDefaults.iconButtonColors(
                    contentColor = Color.Black,
                    containerColor = LightBrown.copy(0.1f)
                )
            ) {
                Icon(
                    painter = painterResource(R.drawable.regular_outline_arrow_left),
                    contentDescription = "Back Arrow",
                    modifier = Modifier.padding(horizontal = 8.dp)
                )
            }
        }
    )

}