package com.example.cinematickets.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.cinematickets.R


@Composable
fun ImageBlur(imagesList: List<Int>, pagePosition: Int) {
    Box(
        modifier = Modifier
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color(0x66000000), Color(0xFFFFFFFF)
                    )
                )
            )
            .fillMaxSize()

    ) {
        Image(
            painter = painterResource(id = imagesList[pagePosition]),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .blur(30.dp)
                .fillMaxWidth()
                .fillMaxHeight(fraction = 0.4f)
        )
    }
}