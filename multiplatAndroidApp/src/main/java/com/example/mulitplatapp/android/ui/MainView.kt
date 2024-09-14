package com.example.mulitplatapp.android.ui


sealed class Screen(val title: String) {
    object TimeZonesScreen : Screen("TimeZones")
    object AddTimeZoneScreen : Screen("Find Time")
}