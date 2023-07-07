package com.example.cinematickets.screens.booking_screen

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.cinematickets.R
import com.example.cinematickets.composable.BookingButton
import com.example.cinematickets.composable.CircleWithText
import com.example.cinematickets.composable.CloseButton
import com.example.cinematickets.composable.HourChips
import com.example.cinematickets.composable.SpacerVertical
import com.example.cinematickets.composable.WeekdayChips
import com.example.cinematickets.ui.theme.Black
import com.example.cinematickets.ui.theme.GrayBlur
import com.example.cinematickets.ui.theme.Orange
import com.example.cinematickets.ui.theme.Sans
import kotlinx.coroutines.launch

@Composable
fun BookingSeatContent(onBackButtonClicked: () -> Unit) {
    val context = LocalContext.current
    val coroutineScope = rememberCoroutineScope()
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        val (columnCinema,
            columnCalendar,
            closeButton,
            cinema, selected,
            taken, available,
            bookingButton, price) = createRefs()
        Column(
            Modifier
                .height(664.dp)
                .fillMaxWidth()
                .background(color = Color.Black)
                .constrainAs(columnCinema) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        ) {}
        CloseButton(
            background = GrayBlur,
            modifier = Modifier.constrainAs(closeButton)
            {
                start.linkTo(parent.start, margin = 8.dp)
                top.linkTo(parent.top, margin = 8.dp)
            }, onClick = onBackButtonClicked
        )
        Image(
            painter = painterResource(R.drawable.cinema),
            contentDescription = stringResource(R.string.cinema), modifier = Modifier
                .constrainAs(cinema) {
                    top.linkTo(closeButton.top, margin = 64.dp)
                }
                .height(120.dp)
                .fillMaxWidth()
        )
        CircleWithText(
            text = stringResource(R.string.selected),
            textColor = Color.White,
            circleColor = Orange,
            modifier = Modifier.constrainAs(selected) {
                top.linkTo(taken.top)
                bottom.linkTo(taken.bottom)
                start.linkTo(taken.end, margin = 48.dp)
            })
        CircleWithText(
            text = stringResource(R.string.taken),
            textColor = Color.LightGray,
            circleColor = Color.DarkGray,
            modifier = Modifier.constrainAs(taken) {
                top.linkTo(available.top)
                bottom.linkTo(available.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            })
        CircleWithText(
            text = stringResource(R.string.available),
            textColor = Color.White,
            circleColor = Color.White,
            modifier = Modifier.constrainAs(available) {
                bottom.linkTo(columnCinema.bottom, margin = 64.dp)
                end.linkTo(taken.start, margin = 48.dp)
            })
        Column(
            Modifier
                .fillMaxWidth()
                .clip(shape = RoundedCornerShape(32.dp))
                .background(color = Color.White)
                .constrainAs(columnCalendar) {
                    top.linkTo(columnCinema.bottom, margin = (-32).dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        ) {
            SpacerVertical(space = 24)
            WeekdayChips()
            SpacerVertical(space = 16)
            HourChips()
            SpacerVertical(space = 16)
        }
        BookingButton(
            stringResource(R.string.buy_tickets),
            modifier = Modifier.constrainAs(bookingButton) {
                bottom.linkTo(parent.bottom, margin = 16.dp)
                end.linkTo(parent.end, margin = 16.dp)
            }, onClick = {
                coroutineScope.launch {
                    Toast.makeText(context, "We wish you a pleasant viewing", Toast.LENGTH_SHORT)
                        .show()
                }
            })
        Column(modifier = Modifier.constrainAs(price) {
            start.linkTo(parent.start, margin = 16.dp)
            bottom.linkTo(parent.bottom, margin = 16.dp)
        }) {
            Text(
                text = stringResource(R.string._100_00),
                color = Black,
                fontFamily = Sans,
                fontWeight = FontWeight.Normal,
                fontSize = 24.sp,
                textAlign = TextAlign.Center
            )
            Text(
                text = stringResource(R.string._4_tickets),
                color = Color.LightGray,
                fontFamily = Sans,
                fontWeight = FontWeight.Normal,
                fontSize = 14.sp,
                textAlign = TextAlign.Center
            )
        }
    }
}