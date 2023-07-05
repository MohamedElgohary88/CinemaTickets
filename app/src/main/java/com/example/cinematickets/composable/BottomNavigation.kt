package com.example.cinematickets.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cinematickets.R
import com.example.cinematickets.ui.theme.Orange


@Preview()
@Composable
fun BottomNavigation() {
    BottomAppBar(
        containerColor = Color.White,
        contentPadding = PaddingValues(start = 16.dp, end = 16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            BottomAppBarItem(drawableResId = R.drawable.movie, selected = true)
            BottomAppBarItem(drawableResId = R.drawable.search, selected = false)
            BottomAppBarItem(drawableResId = R.drawable.ticket, selected = false)
            BottomAppBarItem(drawableResId = R.drawable.user, selected = false)
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
        modifier = Modifier.size(46.dp)
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