package com.example.cinematickets.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cinematickets.R
import com.example.cinematickets.ui.theme.Orange


@Preview
@Composable
fun BottomNavigation() {
    BottomAppBar(
        containerColor = Color.White,
        contentPadding = PaddingValues(start = 16.dp, end = 16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            BottomAppBarItem(drawableResId = R.drawable.ic_movie, selected = true)
            BottomAppBarItem(drawableResId = R.drawable.ic_search, selected = false)
            BottomAppBarItem(drawableResId = R.drawable.ic_ticket, selected = false)
            BottomAppBarItem(drawableResId = R.drawable.ic_user, selected = false)
        }
    }
}

@Composable
fun BottomAppBarItem(drawableResId: Int, selected: Boolean) {
    val iconTint = if (selected) Color.White else Color.Black
    val backgroundColor = if (selected) Orange else Color.Transparent
    val image = painterResource(drawableResId)

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.size(48.dp)
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(48.dp)
                .background(backgroundColor, shape = CircleShape)
        ) {
            Icon(
                painter = image,
                contentDescription = null,
                tint = iconTint
            )
        }
    }
}