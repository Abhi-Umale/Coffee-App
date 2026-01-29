package com.example.coffeeapp.presentation.screens.profilescreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.coffeeapp.presentation.theme.CoffeeBrown
import com.example.coffeeapp.presentation.ui_component.MyBottomNavBar
import com.example.coffeeapp.presentation.ui_component.MyTopAppBar

@Composable
fun ProfileScreen(navController : NavController) {

    Scaffold(
        topBar = { MyTopAppBar("Profile", navController) },
        bottomBar = { MyBottomNavBar(navController,"Profile") }

    ) {innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)
                .padding(innerPadding)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 30.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Box(
                    modifier = Modifier
                        .size(150.dp)
                        .fillMaxWidth()
                        .padding(10.dp)
                        .clip(CircleShape)
                        .background(CoffeeBrown.copy(0.3f)),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.Person,
                        contentDescription = "Profile Image",
                        tint = CoffeeBrown,
                        modifier = Modifier
                            .padding(10.dp)
                            .size(100.dp)
                    )
                }
                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    "Abhi Umale",
                    fontWeight = FontWeight.Bold,
                    fontSize = 25.sp
                )
                Spacer(modifier = Modifier.height(6.dp))
                Text(
                    "ghruabhi143@gmail.com",
                    color = Color.Black,
                    fontSize = 15.sp
                )
            }

            Spacer(modifier = Modifier.height(12.dp))
            Text(
                "Address",
                fontWeight = FontWeight.Bold,
                fontSize = 25.sp
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                "Malikhel Jamod,\nJalgaon Jamod-443402",
                color = Color.Black,
                fontSize = 15.sp
            )
            Spacer(modifier = Modifier.height(40.dp))

            ProfileScreenCard(navController)
        }

    }
}