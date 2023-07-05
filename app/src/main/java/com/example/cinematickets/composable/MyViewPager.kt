package com.example.cinematickets.composable

import androidx.compose.runtime.Composable
import com.example.cinematickets.R

@Composable
fun ViewPagerScreen(imageList: List<Image>) {

}

data class Image(val resId: Int)

val imageList = listOf(
    Image(R.drawable.image_1),
    Image(R.drawable.image_2),
    Image(R.drawable.image_3),
    Image(R.drawable.image_4),
    Image(R.drawable.image_5),
    Image(R.drawable.image_6),
    Image(R.drawable.image_7)
)