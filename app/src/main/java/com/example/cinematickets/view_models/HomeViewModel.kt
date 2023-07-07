package com.example.cinematickets.view_models

import androidx.lifecycle.ViewModel
import com.example.cinematickets.R
import com.example.cinematickets.navigation.CinemaScreens
import com.example.cinematickets.view_models.state.HomeUIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor() : ViewModel() {
    private val _state = MutableStateFlow(HomeUIState())
    val state = _state.asStateFlow()

    private val moviesImages = listOf(R.drawable.image_2, R.drawable.image_1, R.drawable.image_3)

    init {
        _state.update { it.copy(imagesList = moviesImages) }
    }

    fun onMovieImageChanged(newValue: Int) {
        _state.update { it.copy(imagePosition = newValue) }
    }
}