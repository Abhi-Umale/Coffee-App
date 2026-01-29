package com.example.coffeeapp.presentation.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed class Routs {
    @Serializable
    object WelcomeScreen : Routs()
    @Serializable
    object HomeScreen: Routs()
    @Serializable
    data class DetailsScreen(val productId: Int, val productPrice: Double):Routs()
    @Serializable
    object CartScreen: Routs()
    @Serializable
    object FavouritesScreen: Routs()
    @Serializable
    object ProfileScreen: Routs()
}
