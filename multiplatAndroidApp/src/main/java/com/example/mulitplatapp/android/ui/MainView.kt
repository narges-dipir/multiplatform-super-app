package com.example.mulitplatapp.android.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.rounded.Info
import androidx.compose.material.icons.rounded.Place
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshots.Snapshot
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
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
fun MainView(
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
        Scaffold(
            topBar = {
                actionBarFun(selectedIndex.value)
            },
            floatingActionButton = {
            if (selectedIndex.value == 0) {
             FloatingActionButton(
                 modifier = Modifier.padding(16.dp),
                 shape = FloatingActionButtonDefaults.largeShape,
                 containerColor = MaterialTheme.colorScheme.secondary,
                 onClick = {
                           showAddDialog.value = true
                 }
             ) {
              Icon(imageVector = Icons.Default.Add, contentDescription = "Add timezone")
             }
            }
            },
            bottomBar = {
            NavigationBar(containerColor = MaterialTheme.colorScheme.primary) {
                bottomNavigationItems.forEachIndexed { i, bottomNavigationItem ->
                    NavigationBarItem(
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = Color.White,
                            selectedTextColor = Color.White,
                            unselectedIconColor = Color.Black,
                            unselectedTextColor = Color.Black,
                            indicatorColor = MaterialTheme.colorScheme.primary
                        ),
                            selected = selectedIndex.value  == i,
                            onClick = { selectedIndex.value = i },
                            icon = { Icon(imageVector = bottomNavigationItem.icon, contentDescription = bottomNavigationItem.iconContentDescription) },
                            label = { Text(
                                text = bottomNavigationItem.route,
                                style = MaterialTheme.typography.bodyMedium
                            )}
                    )
                }

            }
            },
        ) { padding ->
            Box(modifier = Modifier.padding(padding)) {
                when (selectedIndex.value) {
                    0 -> TimeZoneScreen(currentTimezoneStrings)
//                    1 -> AddTimeZoneScreen(showAddDialog)
                }
            }
        }
    }
}
