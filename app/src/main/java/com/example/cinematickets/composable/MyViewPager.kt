package com.example.cinematickets.composable

import android.annotation.SuppressLint
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cinematickets.R

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Preview(showSystemUi = true)
@Composable
fun ViewPager() {
    val pagerState = rememberPagerState()
    Scaffold() {
        HorizontalPager(
            pageCount = imageList.size,
            state = pagerState,
            pageSpacing = (-32).dp,
            contentPadding = PaddingValues(horizontal = 56.dp),
            modifier = Modifier.fillMaxSize().background(Color.Transparent)
        ) { page ->
            val image = imageList[page]
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
                painter = painterResource(image.resId),
                contentDescription = null,
                modifier = imageSizeModifier
            )
        }
    }
}

data class Image(val resId: Int)

val imageList = listOf(
    Image(R.drawable.image_3),
    Image(R.drawable.image_1),
    Image(R.drawable.image_2),
)