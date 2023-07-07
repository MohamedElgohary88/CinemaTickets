package com.example.cinematickets.screens.home_screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.cinematickets.navigation.CinemaScreens
import com.example.cinematickets.view_models.HomeViewModel

@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()
    HomeContent(
        state,
        onMovieImageChanged = viewModel::onMovieImageChanged,
        onClickMovieImage = { navController.navigate(CinemaScreens.MovieDetailsScreen.route) }
    )
}

