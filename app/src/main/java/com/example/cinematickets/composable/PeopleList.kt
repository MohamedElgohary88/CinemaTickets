package com.example.cinematickets.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.cinematickets.R

@Composable
fun PeopleList() {
    LazyRow(contentPadding = PaddingValues(horizontal = 16.dp)) {
        itemsIndexed(peopleList) { _, person ->
            Image(
                painter = painterResource(person.resId),
                contentDescription = null,
                modifier = Modifier.size(64.dp).padding(4.dp)
            )
        }
    }
}


data class People(val resId: Int)

val peopleList = listOf(
    People(R.drawable.people_1),
    People(R.drawable.people_2),
    People(R.drawable.people_3),
    People(R.drawable.people_4),
    People(R.drawable.people_5),
    People(R.drawable.people_6),
    People(R.drawable.people_7),
)