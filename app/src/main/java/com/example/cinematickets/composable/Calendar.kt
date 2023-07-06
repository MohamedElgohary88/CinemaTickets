package com.example.cinematickets.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

@Composable
fun WeekdayChips() {
    val currentCalendar = Calendar.getInstance()
    val totalDaysOfMonth = currentCalendar.getActualMaximum(Calendar.DAY_OF_MONTH)
    val selectedChipIndex = remember { mutableStateOf(0) }

    val chipItems = List(totalDaysOfMonth) { index ->
        val dayOfMonth = currentCalendar.get(Calendar.DAY_OF_MONTH)
        val dayOfWeek = currentCalendar.getDisplayName(
            Calendar.DAY_OF_WEEK,
            Calendar.SHORT,
            Locale.getDefault()
        )
        val date = "$dayOfMonth\n$dayOfWeek"
        currentCalendar.add(Calendar.DAY_OF_MONTH, -1)
        date
    }

    LazyRow(
        reverseLayout = true,
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        itemsIndexed(chipItems) { index, item ->
            ClickableText(
                text = item,
                isSelected = index == selectedChipIndex.value,
                onClick = { selectedChipIndex.value = index }
            )
        }
    }
}
@Composable
fun HourChips() {
    val currentCalendar = Calendar.getInstance()
    LazyRow(
        modifier = Modifier.padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        items(24) { hour ->
            val time = currentCalendar.apply { set(Calendar.HOUR_OF_DAY, hour) }.time
            val timeString = SimpleDateFormat("h a", Locale.getDefault()).format(time)
            Chip(timeString, false, onClick = {})
        }
    }
}
@Composable
fun ClickableText(text: String, isSelected: Boolean, onClick: () -> Unit) {
    Chip(text = text, selected = isSelected, onClick = onClick)
}