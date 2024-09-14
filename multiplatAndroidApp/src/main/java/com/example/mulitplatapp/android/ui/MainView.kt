package com.example.mulitplatapp.android.ui

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Info
import androidx.compose.material.icons.rounded.Place
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshots.Snapshot
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.mulitplatapp.android.MyApplicationTheme


sealed class Screen(val title: String) {
    data object TimeZonesScreen : Screen("TimeZones")
    data object AddTimeZoneScreen : Screen("Find Time")
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

@Composable
fun MapView(
    actionBarFun: topBarFun = { EmptyComposable() }
) {
    val showAddDialog = remember {
        mutableStateOf(false)
    }
    val currentTimezoneStrings = remember {
        SnapshotStateList<String>()
    }
    val selectedIndex = remember {
        mutableStateOf(0)
    }

    MyApplicationTheme {

    }
}
