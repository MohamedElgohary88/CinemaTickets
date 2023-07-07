package com.example.cinematickets.composable

import android.annotation.SuppressLint
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.cinematickets.R

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun ViewPager(
    moviesList: List<Int>,
    pagerState: PagerState,
    onMovieImageChanged: (Int) -> Unit,
    onClickMovie: () -> Unit
) {
    LaunchedEffect(pagerState) {
        snapshotFlow { pagerState.currentPage }.collect {
            onMovieImageChanged(it)
        }
    }
    Scaffold(
        containerColor = Color.Transparent
    ) {
        HorizontalPager(
            pageCount = moviesList.size,
            state = pagerState,
            pageSpacing = (-32).dp,
            contentPadding = PaddingValues(horizontal = 56.dp),
            modifier = Modifier.fillMaxSize()
        ) { page ->
            val imageSizeModifier = if (page == pagerState.currentPage) {
                Modifier
                    .fillMaxHeight()
                    .width(283.dp)
            } else {
                Modifier
                    .fillMaxHeight()
                    .width(200.dp)
            }
            Image(
                painter = painterResource(id = moviesList[page]),
                contentDescription = null,
                modifier = imageSizeModifier
                    .clickable() { onClickMovie() }
                    .fillMaxSize()
            )
        }
    }
}