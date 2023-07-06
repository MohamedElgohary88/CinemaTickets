package com.example.cinematickets.screens.booking_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.cinematickets.R
import com.example.cinematickets.composable.CircleWithText
import com.example.cinematickets.composable.CloseButton
import com.example.cinematickets.composable.HourChips
import com.example.cinematickets.composable.SpacerVertical
import com.example.cinematickets.composable.WeekdayChips
import com.example.cinematickets.ui.theme.GrayBlur
import com.example.cinematickets.ui.theme.Orange

@Preview(showSystemUi = true)
@Composable
fun BookingSeatContent() {
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        val (columnCinema, columnCalendar, closeButton, cinema, selected, taken, available) = createRefs()
        Column(
            Modifier
                .height(580.dp)
                .fillMaxWidth()
                .background(color = Color.Black)
                .constrainAs(columnCinema) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        ) {}
        CloseButton(background = GrayBlur,
            modifier = Modifier.constrainAs(closeButton)
            {
                start.linkTo(parent.start, margin = 8.dp)
                top.linkTo(parent.top, margin = 16.dp)
            })
        Image(
            painter = painterResource(R.drawable.cinema),
            contentDescription = "cinema", modifier = Modifier
                .constrainAs(cinema) {
                    top.linkTo(closeButton.top, margin = 64.dp)
                }
                .height(120.dp)
                .fillMaxWidth()
        )
        CircleWithText(
            text = "Selected",
            textColor = Color.White,
            circleColor = Orange,
            modifier = Modifier.constrainAs(selected) {
                top.linkTo(taken.top)
                bottom.linkTo(taken.bottom)
                start.linkTo(taken.end, margin = 48.dp)
            })
        CircleWithText(
            text = "Taken",
            textColor = Color.LightGray,
            circleColor = Color.DarkGray,
            modifier = Modifier.constrainAs(taken) {
                top.linkTo(available.top)
                bottom.linkTo(available.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            })
        CircleWithText(
            text = "Available",
            textColor = Color.White,
            circleColor = Color.White,
            modifier = Modifier.constrainAs(available) {
                bottom.linkTo(columnCinema.bottom, margin = 64.dp)
                end.linkTo(taken.start, margin = 48.dp)
            })
        Column(
            Modifier
                .height(300.dp)
                .fillMaxWidth()
                .clip(shape = RoundedCornerShape(32.dp))
                .background(color = Color.White)
                .constrainAs(columnCalendar) {
                    top.linkTo(columnCinema.bottom, margin = (-32).dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        ) {
            SpacerVertical(space = 16)
            WeekdayChips()
            SpacerVertical(space = 16)
            HourChips()
        }
    }
}