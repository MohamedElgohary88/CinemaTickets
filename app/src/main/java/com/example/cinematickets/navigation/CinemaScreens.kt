package com.example.cinematickets.navigation

sealed class CinemaScreens(val route: String) {
    object HomeScreen : CinemaScreens("HomeScreen")
    object MovieDetailsScreen : CinemaScreens("MovieDetailsScreen")
    object BookingSeatScreen : CinemaScreens("BookingSeatScreen")
}