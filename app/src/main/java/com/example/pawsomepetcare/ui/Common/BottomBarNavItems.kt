package com.example.pawsomepetcare.ui.Common

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CalendarToday
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.outlined.CalendarToday
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.pawsomepetcare.navigation.Screens

data class BottomBarNavItem(

    val label: String,
    val filledIcon:ImageVector,
    val outlinedIcon:ImageVector,
    val route: String
)

val listOfNavItems:List<BottomBarNavItem> = listOf(
    BottomBarNavItem(
        label = "Home",
        filledIcon = Icons.Filled.Home,
        outlinedIcon = Icons.Outlined.Home,
        route = Screens.HomeScreen.name
    ),
    BottomBarNavItem(
        label = "Services",
        filledIcon = Icons.Filled.CalendarToday,
        outlinedIcon = Icons.Outlined.CalendarToday,
        route = Screens.ServicesScreen.name
    ),
    BottomBarNavItem(
        label = "Cart",
        filledIcon = Icons.Filled.ShoppingCart,
        outlinedIcon = Icons.Outlined.ShoppingCart,
        route = Screens.CartScreen.name
    ),
    BottomBarNavItem(
        label = "Profile",
        filledIcon = Icons.Filled.Person,
        outlinedIcon = Icons.Outlined.Person,
        route = Screens.ProfileScreen.name
    )
)