package com.example.cinematickets.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cinematickets.screens.home_screen.HomeScreen
import com.example.cinematickets.ui.theme.Orange
import com.example.cinematickets.ui.theme.Teal

@Preview(showSystemUi = true)
@Composable
fun MyUI() {
    val boxSize = with(LocalDensity.current) { 380.dp.toPx() }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .background(
                    brush = Brush.linearGradient(
                        colors = listOf(Teal, Orange),
                        start = Offset(5f, 0f),
                        end = Offset(boxSize, boxSize)
                    )
                )
        ) {
            HomeScreen()
        }
    }
}
