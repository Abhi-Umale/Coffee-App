package com.example.coffeeapp.presentation.ui_component

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.coffeeapp.R
import com.example.coffeeapp.presentation.navigation.Routs
import com.example.coffeeapp.presentation.theme.CharcoalGray
import com.example.coffeeapp.presentation.theme.LightBrown

@Composable
fun MyBottomNavBar(navController: NavController,routs: String) {

    //Nav Items
    val navItems = listOf(
        navItem("Home", R.drawable.regular_outline_home, Routs.HomeScreen),
        navItem("Cart", R.drawable.regular_outline_bag, Routs.CartScreen),
        navItem("Favourites", R.drawable.regular_outline_heart, Routs.FavouritesScreen),
        navItem("Profile", R.drawable.outline_account_circle_24, Routs.ProfileScreen)
    )

    NavigationBar(
        containerColor = MaterialTheme.colorScheme.surface,
        modifier = Modifier.height(100.dp)
    ) {
        navItems.forEachIndexed { index, item ->
            NavigationBarItem(
                icon = {
                    Icon(
                        painter = painterResource(item.icon),
                        contentDescription = item.title
                    )
                },
                label = { Text(item.title) },
                modifier = Modifier.size(30.dp),
                onClick = {
                    navController.navigate(item.routs){
                        popUpTo(navController.graph.startDestinationId){
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                selected = item.title == routs,
                alwaysShowLabel = false,
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = LightBrown,
                    selectedTextColor = LightBrown,
                    unselectedIconColor = CharcoalGray,
                    unselectedTextColor = CharcoalGray,
                    indicatorColor = LightBrown.copy(0.03f)
                ),
            )
        }
    }
}

data class navItem(
    val title: String,
    val icon: Int,
    val routs: Routs
)