package com.example.cinematickets.screens.home_screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cinematickets.R
import com.example.cinematickets.composable.BottomNavigation
import com.example.cinematickets.composable.Chip
import com.example.cinematickets.composable.ImageBlur
import com.example.cinematickets.composable.SpacerHorizontal
import com.example.cinematickets.composable.SpacerVertical
import com.example.cinematickets.composable.ViewPager
import com.example.cinematickets.ui.theme.Black
import com.example.cinematickets.ui.theme.Orange
import com.example.cinematickets.ui.theme.Sans
import com.example.cinematickets.view_models.state.HomeUIState

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeContent(
    state: HomeUIState, onMovieImageChanged: (Int) -> Unit, onClickMovieImage: () -> Unit
) {
    ImageBlur(imagesList = state.imagesList, pagePosition = state.imagePosition)
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        SpacerVertical(24)
        HeaderButtons()
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.8f)
        ) {
            ViewPager(
                state.imagesList,
                rememberPagerState(initialPage = 1),
                onMovieImageChanged,
                onClickMovieImage
            )
        }
        MovieLength()
        SpacerVertical(16)
        MovieTitle()
        SpacerVertical(24)
        GenresChips()
        SpacerVertical(48)
        BottomNavigation()
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
        SpacerHorizontal(8)
        HeaderButton(
            text = "Coming Soon",
            containerColor = Color.Transparent,
            contentColor = Color.White,
            borderColor = Color.LightGray
        )
    }
}

@Composable
fun HeaderButton(
    text: String, containerColor: Color, contentColor: Color,
    borderColor: Color = Color.Transparent, onClick: () -> Unit = {},
) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(containerColor),
        border = BorderStroke(1.dp, borderColor),
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
fun MovieLength() {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Image(painter = painterResource(id = R.drawable.ic_clock), contentDescription = null)
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
        color = Black,
        fontFamily = Sans,
        fontWeight = FontWeight.Normal,
        fontSize = 24.sp,
        textAlign = TextAlign.Center
    )
}

@Composable
fun GenresChips() {
    Row {
        Chip(text = "Fantasy", false, onClick = {})
        SpacerHorizontal(space = 4)
        Chip(text = "Adventure", false, onClick = {})
    }
}