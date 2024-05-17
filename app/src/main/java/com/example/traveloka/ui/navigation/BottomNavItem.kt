package com.example.traveloka.ui.navigation

import com.example.traveloka.R
import com.example.traveloka.screen.destinations.BlankScreenDestination
import com.example.traveloka.screen.destinations.Destination
import com.example.traveloka.screen.destinations.HomeScreenDestination


/**
 * Created by wahid on 5/16/2024.
 * Github github.com/wahidabd.
 */


sealed class BottomNavItem(
    val title: String,
    val icon: Int,
    val destination: Destination
) {
    data object Home : BottomNavItem(
        title = "Home",
        icon = R.drawable.outline_home_24,
        destination = HomeScreenDestination
    )

    data object Saved : BottomNavItem(
        title = "Saved",
        icon = R.drawable.outline_save_24,
        destination = BlankScreenDestination
    )

    data object Booking : BottomNavItem(
        title = "Booking",
        icon = R.drawable.outline_book_24,
        destination = BlankScreenDestination
    )

    data object Inbox : BottomNavItem(
        title = "Inbox",
        icon = R.drawable.outline_inbox_24,
        destination = BlankScreenDestination
    )

    data object Account : BottomNavItem(
        title = "Account",
        icon = R.drawable.outline_account_circle_24,
        destination = BlankScreenDestination
    )
}