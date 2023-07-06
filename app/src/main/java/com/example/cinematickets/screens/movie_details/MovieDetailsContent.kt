package com.example.cinematickets.screens.movie_details

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.cinematickets.R
import com.example.cinematickets.composable.BookingButton
import com.example.cinematickets.composable.Chip
import com.example.cinematickets.composable.CloseButton
import com.example.cinematickets.composable.ColoredText
import com.example.cinematickets.composable.PeopleList
import com.example.cinematickets.composable.SpacerHorizontal
import com.example.cinematickets.composable.SpacerVertical
import com.example.cinematickets.screens.home_screen.MovieTitle
import com.example.cinematickets.ui.theme.Black67
import com.example.cinematickets.ui.theme.TealBlur
import com.example.cinematickets.ui.theme.OrangeBlur
import com.example.cinematickets.ui.theme.Orange
import com.example.cinematickets.ui.theme.Sans

@Preview(showSystemUi = true)
@Composable
fun MovieDetailsContent() {
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        val (play, timer, movieImage, close, bottomSheet) = createRefs()
        Image(
            painter = painterResource(id = R.drawable.movie_details),
            contentDescription = "movie image",
            modifier = Modifier
                .height(380.dp)
                .fillMaxWidth()
                .constrainAs(movieImage) {
                    top.linkTo(parent.top)
                },
            contentScale = ContentScale.Crop
        )

        CloseButton(background = OrangeBlur.copy(alpha = .87f),
            modifier = Modifier.constrainAs(close) {
                start.linkTo(parent.start)
                top.linkTo(parent.top)
            })

        Row(
            modifier = Modifier
                .padding(end = 16.dp)
                .clip(shape = RoundedCornerShape(16.dp))
                .background(color = TealBlur.copy(alpha = .87f))
                .constrainAs(timer) {
                    end.linkTo(parent.end)
                    top.linkTo(close.top)
                    bottom.linkTo(close.bottom)
                }
        ) {
            Image(
                painter = painterResource(id = R.drawable.clock),
                contentDescription = null,
                modifier = Modifier
                    .wrapContentSize()
                    .padding(start = 8.dp)
                    .align(Alignment.CenterVertically)
            )
            Text(
                text = "2h 23m",
                color = Color.White,
                modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
            )
        }



        Box(
            modifier = Modifier
                .constrainAs(play) {
                    start.linkTo(movieImage.start)
                    end.linkTo(movieImage.end)
                    top.linkTo(movieImage.top)
                    bottom.linkTo(movieImage.bottom)
                }
                .size(56.dp)
                .background(Orange, CircleShape),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.play),
                contentDescription = "contentDescription",
                modifier = Modifier.size(48.dp / 2)
            )
        }
        Column(
            modifier = Modifier
                .padding(top = 160.dp)
                .clip(shape = RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp))
                .background(Color.White)
                .fillMaxSize()
                .constrainAs(bottomSheet) {
                    top.linkTo(movieImage.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(parent.bottom)
                },
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            SpacerVertical(space = 32)
            Row {
                ColoredText("6.8/10", "IMDb", charsInBlack = 3)
                SpacerHorizontal(space = 48)
                ColoredText("63%", "Rotten Tomatoes", charsInBlack = 3)
                SpacerHorizontal(space = 48)
                ColoredText("4/10", "IGN", charsInBlack = 1)
            }
            SpacerVertical(space = 16)
            MovieTitle()
            SpacerVertical(space = 20)
            Row {
                Chip(text = "Fantasy",false, onClick = {})
                SpacerHorizontal(space = 4)
                Chip(text = "Adventure",false, onClick = {})
            }
            SpacerVertical(space = 20)
            PeopleList()
            SpacerVertical(space = 20)
            Text(
                text = stringResource(R.string.movie_description),
                color = Black67,
                fontSize = 12.sp,
                fontFamily = Sans,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Normal,
                modifier = Modifier.padding(horizontal = 12.dp)
            )
            SpacerVertical(space = 24)
            BookingButton()
        }
    }
}