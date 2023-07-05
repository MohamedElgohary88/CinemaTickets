package com.example.cinematickets.screens.home_screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
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

@Preview(showSystemUi = true)
@Composable
fun HomeScreen() {
    HomeContent()
}

