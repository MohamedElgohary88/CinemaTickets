package com.example.cinematickets.view_models.state

import androidx.annotation.DrawableRes

data class HomeUIState(
    @DrawableRes val imagesList: List<Int> = emptyList(),
    val imagePosition: Int = 1,
    val movieLength: String = "",
    val movieName: String = "",
)