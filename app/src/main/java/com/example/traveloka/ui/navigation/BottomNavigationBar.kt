package com.example.traveloka.ui.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState


/**
 * Created by wahid on 5/16/2024.
 * Github github.com/wahidabd.
 */


@Composable
fun BottomNavigationBar(
    navController: NavController,
    showBottomBar: Boolean = true,
    items: List<BottomNavItem> = listOf(
        BottomNavItem.Home,
        BottomNavItem.Saved,
        BottomNavItem.Booking,
        BottomNavItem.Inbox,
        BottomNavItem.Account
    ),
    content: @Composable (paddingValues: PaddingValues) -> Unit
) {
    Scaffold(
        bottomBar = {
            if (showBottomBar) {
                NavigationBar(
                    containerColor = Color.White,
                    contentColor = Color.Unspecified,
                    tonalElevation = 4.dp
                ) {
                    val navBackStackEntry by navController.currentBackStackEntryAsState()
                    val currentItem = navBackStackEntry?.destination

                    items.forEach { item ->
                        NavigationBarItem(
                            icon = {
                                Icon(
                                    painter = painterResource(id = item.icon),
                                    tint = Color.Gray,
                                    contentDescription = item.title
                                )
                            },
                            label = {
                                Text(
                                    text = item.title,
                                    style = MaterialTheme.typography.labelSmall,
                                )
                            },
                            alwaysShowLabel = true,
                            selected = currentItem?.route?.contains(item.destination.route) == true,
                            onClick = {
                                navController.navigate(item.destination.route) {
                                    navController.graph.startDestinationRoute?.let { route ->
                                        popUpTo(route) {
                                            saveState = true
                                        }
                                    }
                                    launchSingleTop = true
                                    restoreState = true
                                }
                            },
                            colors = NavigationBarItemDefaults.colors(
                                indicatorColor = Color.Transparent
                            )
                        )
                    }
                }
            }
        },
    ) { paddingValues ->
        content(paddingValues)
    }
}