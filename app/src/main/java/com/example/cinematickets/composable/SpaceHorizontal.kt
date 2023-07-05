package com.example.cinematickets.composable

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SpacerHorizontal32() {
    Spacer(modifier = Modifier.width(32.dp))
}

@Composable
fun SpacerHorizontal16() {
    Spacer(modifier = Modifier.width(16.dp))
}

@Composable
fun SpacerHorizontal8() {
    Spacer(modifier = Modifier.width(8.dp))
}