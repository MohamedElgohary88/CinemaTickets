package com.example.cinematickets.composable

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cinematickets.R
import com.example.cinematickets.ui.theme.Orange
import kotlin.random.Random


@Preview(showSystemUi = true)
@Composable
fun SeatsLayout(modifier: Modifier = Modifier) {
    val selectedSeats = remember { mutableStateListOf<Int>() }

    Row(modifier = modifier.padding(vertical = 8.dp)) {
        repeat(6) { columnIndex ->
            val paddingStart = if (columnIndex % 2 == 1) 4.dp else 16.dp
            val paddingEnd = if (columnIndex % 2 == 0) 4.dp else 16.dp
            Row(
                modifier = Modifier
                    .weight(1f)
                    .padding(start = paddingStart, end = paddingEnd)
            ) {
                Column(
                    modifier = Modifier
                        .padding(horizontal = 8.dp)
                ) {
                    repeat(5) { rowIndex ->
                        val seatNumber = (columnIndex * 5) + rowIndex + 1
                        val isSelected = selectedSeats.contains(seatNumber)
                        val seatRotation = getSeatRotation(columnIndex, rowIndex)
                        Seat(seatNumber, isSelected, seatRotation) {
                            if (isSelected) {
                                selectedSeats.remove(seatNumber)
                            } else {
                                selectedSeats.add(seatNumber)
                            }
                        }
                        if (rowIndex < 4) {
                            Spacer(modifier = Modifier.height(24.dp))
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Seat(seatNumber: Int, isSelected: Boolean, rotationAngle: Float, onClick: () -> Unit) {
    val random = remember { Random }
    val randomGraySeats = remember { mutableStateListOf<Int>() }

    val seatColor = when {
        isSelected -> Orange
        seatNumber in randomGraySeats -> Color.Gray
        else -> Color.White
    }
    Box(
        modifier = Modifier
            .size(48.dp)
            .rotate(rotationAngle)
    ) {
        IconSeat(modifier = Modifier.fillMaxSize(), tint = seatColor)
        if (!isSelected && seatNumber !in randomGraySeats) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .clickable(onClick = onClick)
            )
        }
    }
    LaunchedEffect(Unit) {
        repeat(10) {
            val randomSeat = random.nextInt(1, 31)
            randomGraySeats.add(randomSeat)
        }
    }
}


fun getSeatRotation(columnIndex: Int, rowIndex: Int): Float {
    return when {
        (columnIndex == 0 || columnIndex == 1) && rowIndex in 0..4 -> 11.5f
        (columnIndex == 4 || columnIndex == 5) && rowIndex in 0..4 -> -11.5f
        else -> 0f
    }
}

@Composable
fun IconSeat(modifier: Modifier = Modifier, tint: Color = Color(0xCC787878)) {
    Icon(
        tint = tint,
        modifier = modifier.fillMaxSize(),
        contentDescription = stringResource(R.string.seat),
        painter = painterResource(id = R.drawable.ic_seat),
    )
}