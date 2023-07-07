package com.example.cinematickets.screens.booking_screen

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.cinematickets.navigation.CinemaScreens
import com.example.cinematickets.view_models.HomeViewModel

@Composable
fun BookingSeatScreen(
    navController: NavController,
) {
    BookingSeatContent { navController.popBackStack(CinemaScreens.MovieDetailsScreen.route, false) }
}
