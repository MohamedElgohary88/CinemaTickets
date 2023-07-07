package com.example.cinematickets

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.cinematickets.navigation.CinemaScreens
import com.example.cinematickets.screens.booking_screen.BookingSeatScreen
import com.example.cinematickets.screens.home_screen.HomeScreen
import com.example.cinematickets.screens.movie_details.MovieDetailsScreen

@Composable
fun CinemaTicketsApp() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = CinemaScreens.HomeScreen.route) {
        composable(CinemaScreens.HomeScreen.route) { HomeScreen(navController) }
        composable(CinemaScreens.MovieDetailsScreen.route) { MovieDetailsScreen(navController) }
        composable(CinemaScreens.BookingSeatScreen.route) { BookingSeatScreen(navController) }
    }
}