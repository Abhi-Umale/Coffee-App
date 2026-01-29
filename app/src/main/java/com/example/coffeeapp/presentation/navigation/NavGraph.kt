package com.example.coffeeapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.coffeeapp.presentation.screens.cartscreen.CartScreen
import com.example.coffeeapp.presentation.screens.detailsscreen.DetailsScreen
import com.example.coffeeapp.presentation.screens.favouritescreens.FavouriteScreen
import com.example.coffeeapp.presentation.screens.homescreen.HomeScreen
import com.example.coffeeapp.presentation.screens.profilescreen.ProfileScreen
import com.example.coffeeapp.presentation.screens.welcomescreen.WelcomeScreen

@Composable
fun NavGraph() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Routs.WelcomeScreen
    ) {

        composable<Routs.WelcomeScreen> {
            WelcomeScreen(navController)
        }
        composable<Routs.HomeScreen> {
            HomeScreen(navController)
        }
        composable<Routs.DetailsScreen> { backStackEntry ->
            val args = backStackEntry.toRoute<Routs.DetailsScreen>()
            DetailsScreen(productId = args.productId, productPrice = args.productPrice,navController)
        }
        composable<Routs.CartScreen> {
            CartScreen(navController)
        }
        composable<Routs.FavouritesScreen>{
            FavouriteScreen(navController)
        }
        composable<Routs.ProfileScreen> {
            ProfileScreen(navController)
        }

    }

}