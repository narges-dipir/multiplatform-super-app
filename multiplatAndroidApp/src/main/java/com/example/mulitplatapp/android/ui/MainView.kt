package com.example.mulitplatapp.android.ui

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Info
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material.icons.rounded.Place
import androidx.compose.ui.graphics.vector.ImageVector


sealed class Screen(val title: String) {
    object TimeZonesScreen : Screen("TimeZones")
    object AddTimeZoneScreen : Screen("Find Time")
}

data class BottomItem(
    val route: String,
    val icon: ImageVector,
    val iconContentDescription: String
)

val bottomNavigationItems = listOf(
    BottomItem(Screen.TimeZonesScreen.title, Icons.Rounded.Info, "Timezones"),
    BottomItem(Screen.AddTimeZoneScreen.title, Icons.Rounded.Place, "Find Time")
)