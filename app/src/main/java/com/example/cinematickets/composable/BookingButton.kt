package com.example.cinematickets.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.cinematickets.R
import com.example.cinematickets.ui.theme.Orange

@Composable
fun BookingButton() {
    Row(
        modifier = Modifier
            .clip(shape = RoundedCornerShape(32.dp))
            .background(color = Orange)
            .wrapContentSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.cart),
            contentDescription = null,
            modifier = Modifier
                .wrapContentSize()
                .padding(start = 20.dp)
                .align(Alignment.CenterVertically)
        )
        Text(
            text = "Booking",
            color = Color.White,
            modifier = Modifier.padding(start = 8.dp, end = 20.dp, top = 12.dp, bottom = 12.dp)
        )
    }
}