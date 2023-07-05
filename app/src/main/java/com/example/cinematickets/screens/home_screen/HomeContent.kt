package com.example.cinematickets.screens.home_screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cinematickets.R
import com.example.cinematickets.composable.BottomNavigation
import com.example.cinematickets.composable.Chip
import com.example.cinematickets.composable.SpacerHorizontal8
import com.example.cinematickets.composable.SpacerVertical16
import com.example.cinematickets.composable.SpacerVertical32
import com.example.cinematickets.composable.ViewPager
import com.example.cinematickets.ui.theme.Orange
import com.example.cinematickets.ui.theme.Sans

@Composable
fun HomeContent() {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.background),
            contentDescription = null,
            modifier = Modifier.height(200.dp),
            contentScale = ContentScale.FillBounds
        )
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            SpacerVertical32()
            HeaderButtons()
            SpacerVertical32()
            Box(
                modifier = Modifier
                    .height(395.dp)
                    .fillMaxWidth()
                    .weight(1f)
            ) {
                ViewPager()
            }
            SpacerVertical32()
            ClockImage()
            SpacerVertical16()
            MovieTitle()
            SpacerVertical32()
            GenresChips()
            BottomNavigation()
        }
    }
}


@Composable
fun HeaderButtons() {
    Row {
        HeaderButton(
            text = "Now Showing",
            containerColor = Orange,
            contentColor = Color.White
        )
        SpacerHorizontal8()
        HeaderButton(
            text = "Coming Soon",
            containerColor = Color.Transparent,
            contentColor = Color.DarkGray,
            borderColor = Color.DarkGray
        )
    }
}

@Composable
fun HeaderButton(
    text: String, containerColor: Color, contentColor: Color,
    borderColor: Color = Color.DarkGray, onClick: () -> Unit = {}
) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(containerColor),
        border = BorderStroke(1.dp, borderColor)
    ) {
        Text(
            text = text,
            color = contentColor,
            fontFamily = Sans,
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp
        )
    }
}


@Composable
fun ClockImage() {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Image(painter = painterResource(id = R.drawable.clock), contentDescription = null)
        Text(
            text = "22h 35m",
            color = Color.Black,
            modifier = Modifier.padding(start = 4.dp)
        )
    }
}

@Composable
fun MovieTitle() {
    Text(
        text = "Fantastic Beasts: The \n Secrets of Dumbledore",
        color = Color.Black,
        fontFamily = Sans,
        fontWeight = FontWeight.Normal,
        fontSize = 24.sp,
        textAlign = TextAlign.Center
    )
}

@Composable
fun GenresChips() {
    Row {
        Chip(text = "Fantasy")
        Chip(text = "Adventure")
    }
}