package com.example.cinematickets.view_models

import androidx.lifecycle.ViewModel
import com.example.cinematickets.R
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class MovieDetailsViewModel @Inject constructor() : ViewModel() {
    private val _state = MutableStateFlow(MovieDetailsUIState())
    val state = _state.asStateFlow()

    init {
        _state.update {
            it.copy(
                imageUrl = R.drawable.movie_details
            )
        }
    }
}