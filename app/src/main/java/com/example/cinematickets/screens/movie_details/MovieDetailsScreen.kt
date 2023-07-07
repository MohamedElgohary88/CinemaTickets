package com.example.cinematickets.screens.movie_details

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.cinematickets.navigation.CinemaScreens
import com.example.cinematickets.view_models.MovieDetailsViewModel

@Composable
fun MovieDetailsScreen(
    navController: NavController,
    viewModel: MovieDetailsViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()
    MovieDetailsContent(
        state = state,
        onBookingButtonClicked = {navController.navigate(CinemaScreens.BookingSeatScreen.route)},
        onBackButtonClicked = { navController.popBackStack(CinemaScreens.HomeScreen.route, false) },
    )
}