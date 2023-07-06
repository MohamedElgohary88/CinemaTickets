package com.example.cinematickets.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun ColoredText(text: String, text2: String, charsInBlack: Int) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.wrapContentSize()
    ) {
        Row {
            Text(
                text = text.substring(0, charsInBlack),
                color = Color.Black,
                textAlign = TextAlign.Center,
                modifier = Modifier.wrapContentSize()
            )
            Text(
                text = text.substring(charsInBlack),
                color = Color.LightGray,
                textAlign = TextAlign.Center,
                modifier = Modifier.wrapContentSize()
            )
        }
        Text(
            text = text2,
            color = Color.LightGray,
            textAlign = TextAlign.Center,
            modifier = Modifier.wrapContentSize()
        )
    }
}


@Composable
fun CircleWithText(
    text: String,
    textColor: Color,
    circleColor: Color,
    modifier: Modifier = Modifier
) {
    Row(verticalAlignment = Alignment.CenterVertically, modifier = modifier) {
        Box(
            modifier = modifier
                .size(13.dp)
                .background(circleColor, shape = CircleShape),
            contentAlignment = Alignment.Center
        ) {}
        Text(
            text = text,
            color = textColor,
            textAlign = TextAlign.Center,
            modifier = modifier.padding(start = 4.dp)
        )
    }
}