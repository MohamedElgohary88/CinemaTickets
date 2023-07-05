package com.example.cinematickets.composable

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SpacerVertical32() {
    Spacer(modifier = Modifier.height(32.dp))
}

@Composable
fun SpacerVertical16() {
    Spacer(modifier = Modifier.height(16.dp))
}

@Composable
fun SpacerVertical8() {
    Spacer(modifier = Modifier.height(8.dp))
}