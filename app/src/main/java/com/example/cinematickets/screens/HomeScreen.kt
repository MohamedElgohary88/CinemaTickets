package com.example.cinematickets.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cinematickets.R
import com.example.cinematickets.composable.BottomNavigation
import com.example.cinematickets.composable.SpacerHorizontal8
import com.example.cinematickets.composable.SpacerVertical16
import com.example.cinematickets.composable.SpacerVertical32
import com.example.cinematickets.composable.ViewPagerScreen
import com.example.cinematickets.composable.imageList
import com.example.cinematickets.ui.theme.Black
import com.example.cinematickets.ui.theme.Orange
import com.example.cinematickets.ui.theme.Sans


@Preview(showSystemUi = true)
@Composable
fun HomeScreen() {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SpacerVertical32()
        Row {
            Button(
                onClick = {},
                colors = ButtonDefaults.buttonColors(containerColor = Orange)
            ) {
                Text(
                    text = "Now Showing", color = Color.White,
                    fontFamily = Sans,
                    fontWeight = FontWeight.Normal,
                    fontSize = 16.sp
                )
            }
            SpacerHorizontal8()
            Button(
                onClick = {},
                border = BorderStroke(1.dp, Color.DarkGray),
                colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.DarkGray)
            ) {
                Text(
                    text = "Coming Soon", color = Color.White,
                    fontFamily = Sans,
                    fontWeight = FontWeight.Normal,
                    fontSize = 16.sp
                )
            }
        }
        SpacerVertical32()
        ViewPagerScreen(imageList = imageList)
        SpacerVertical32()
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(painter = painterResource(id = R.drawable.clock), contentDescription = null)
            Text(
                text = "22h 35m",
                color = Color.Black,
                modifier = Modifier.padding(start = 4.dp)
            )
        }
        SpacerVertical16()
        Text(
            text = "Fantastic Beasts: The \n Secrets of Dumbledore",
            color = Color.Black,
            fontFamily = Sans,
            fontWeight = FontWeight.Normal,
            fontSize = 24.sp,
            textAlign = TextAlign.Center
        )
        SpacerVertical32()
        Row {
            Button(
                onClick = {},
                border = BorderStroke(1.dp, Color.DarkGray),
                colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.DarkGray)
            ) {
                Text(
                    text = "Fantasy", color = Black,
                    fontFamily = Sans,
                    fontWeight = FontWeight.Normal,
                    fontSize = 16.sp
                )
            }
            SpacerHorizontal8()
            Button(
                onClick = {},
                border = BorderStroke(1.dp, Color.DarkGray),
                colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.DarkGray)
            ) {
                Text(
                    text = "Adventure", color = Black,
                    fontFamily = Sans,
                    fontWeight = FontWeight.Normal,
                    fontSize = 16.sp
                )
            }
        }
        BottomNavigation()
    }

}