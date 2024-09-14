package com.example.mulitplatapp.android.ui

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