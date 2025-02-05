package com.example.pawsomepetcare.ui.Common

import androidx.compose.foundation.layout.height
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.pawsomepetcare.ui.theme.PawsomePetCareTheme

@Composable
fun BottomNavBar(navController: NavController) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    val colors = MaterialTheme.colorScheme

    NavigationBar(
        containerColor = colors.secondaryContainer,
        contentColor = colors.onSecondaryContainer
    )
    {
        listOfNavItems.forEach { navItem ->
            NavigationBarItem(
                modifier = Modifier.height(20.dp),
                selected = currentDestination?.hierarchy?.any { it.route == navItem.route } == true,
                onClick = {
                    navController.navigate(navItem.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                icon = {
                    val currentRoute = currentDestination?.route
                    val icon: ImageVector = if (currentRoute == navItem.route) {
                        navItem.filledIcon
                    } else {
                        navItem.outlinedIcon
                    }
                    Icon(
                        imageVector = icon,
                        contentDescription = null,
                        tint = if (currentRoute == navItem.route) colors.onSecondaryContainer else Color.White
                    )
                },
                label = {
                    Text(
                        text = navItem.label,
                        color = if (currentDestination?.route == navItem.route) colors.onSecondaryContainer else Color.White,
                        style = typography.labelLarge
                    )
                },

                )
        }
    }
}

@Preview@Composable
fun BottomNavBarPreview() {
    PawsomePetCareTheme {
        BottomNavBar(navController = rememberNavController())
    }
}