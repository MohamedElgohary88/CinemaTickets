package com.example.cinematickets.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
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