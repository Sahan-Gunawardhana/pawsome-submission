package com.example.pawsomepetcare.navigation

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.pawsomepetcare.Authentications.AuthViewModel
import com.example.pawsomepetcare.ui.Common.BottomNavBar
import com.example.pawsomepetcare.ui.Common.TopBarSettings
import com.example.pawsomepetcare.ui.Common.TopBarSettingsWithBack
import com.example.pawsomepetcare.ui.Common.TopBarSettingsWithGreeting
import com.example.pawsomepetcare.ui.screens.landingScreen.LandingScreen
import com.example.pawsomepetcare.ui.screens.loginScreen.LoginScreen
import com.example.pawsomepetcare.ui.screens.productsScreen.ProductDetails
import com.example.pawsomepetcare.ui.screens.signUp.SignUpScreen
import com.example.pawsomepetcare.ui.screens.cartscreen.CartScreen
import com.example.pawsomepetcare.ui.screens.favouritesscreen.FavouritesScreen
import com.example.pawsomepetcare.ui.screens.homescreen.HomeScreen
import com.example.pawsomepetcare.ui.screens.profilescreen.ProfileScreen
import com.example.pawsomepetcare.ui.screens.servicesscreen.ServicesScreen


@Composable
fun AppNavigation(modifier: Modifier = Modifier, authViewModel: AuthViewModel) {
    val navController = rememberNavController()

    //displays the top bar on the correct screens
    fun shouldShowBottomBar(route: String?): Boolean {
        return when (route) {
            Screens.HomeScreen.route,
            Screens.ServicesScreen.route,
            Screens.CartScreen.route,
            Screens.ProductScreen.route,
            Screens.ProfileScreen.route, -> true
            else -> false
        }
    }
    //displays the top bar on the correct screens
    fun shouldShowTopBarWithBack(route: String?): Boolean {
        return when (route) {
            Screens.ProductScreen.route,
            Screens.FavouritesScreen.route,
            Screens.CheckOutScreen.route,
            "productDetails/{productId}"-> true
            else -> false
        }
    }
    //displays the top bar on the correct screens
    fun shouldShowTopBarWithGreeting(route: String?): Boolean {
        return route == Screens.HomeScreen.route
    }
    //displays the top bar on the correct screens
    fun shouldShowTopBarSettings(route: String?): Boolean {
        return when (route) {
            Screens.ServicesScreen.route,
            Screens.CartScreen.route,
            Screens.ProfileScreen.route -> true
            else -> false
        }
    }

    Scaffold(
        topBar = {
            val route = navController.currentBackStackEntryAsState().value?.destination?.route
            val screenName = Screens.entries
                .find { it.route == route }
                ?.name
                ?.replace("Screen", "") ?: ""

            when {
                shouldShowTopBarWithBack(route) -> {
                    TopBarSettingsWithBack(
                        onBackArrowClick = { navController.popBackStack() },
                        onSettingsClick = {}
                    )
                }

                shouldShowTopBarWithGreeting(route) -> {
                    TopBarSettingsWithGreeting (
                        onSettingsClick = { /* Handle settings click */ },
                        navController = navController,
                        authViewModel = authViewModel
                    )
                }

                shouldShowTopBarSettings(route) -> {
                    TopBarSettings(
                        title = screenName,
                        navController = navController,
                        authViewModel = authViewModel
                    )
                }
                else -> null
            }
        },
        bottomBar = {
            if (shouldShowBottomBar(navController.currentBackStackEntryAsState().value?.destination?.route)) {
                BottomNavBar(navController = navController)
            }
        }
    ) { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = Screens.LandingScreen.route,
            modifier = Modifier
                .padding(paddingValues)
        ) {
            composable(
                route = Screens.LandingScreen.route,enterTransition = { fadeIn(tween(1000))}, exitTransition = { fadeOut(tween(1000))}
            ) {
                LandingScreen(navController)
            }
            composable(
                route = Screens.SignUpScreen.route,enterTransition = { fadeIn(tween(1000))}, exitTransition = { fadeOut(tween(1000))}
            ) {
                SignUpScreen(navController, authViewModel = authViewModel)
            }
            composable(
                route = Screens.LoginScreen.route,enterTransition = { fadeIn(tween(1000))}, exitTransition = { fadeOut(tween(1000))}
            ) {
                LoginScreen(navController, authViewModel = authViewModel)
            }
            composable(route = Screens.HomeScreen.route, enterTransition = { fadeIn(tween(500))}, exitTransition = { fadeOut(tween(500))}) {
                HomeScreen(navController, authViewModel = authViewModel)
            }
            composable(route = Screens.ServicesScreen.route, enterTransition = { fadeIn(tween(500))}, exitTransition = { fadeOut(tween(500))}) {
                ServicesScreen(navController)
            }
            composable(route = Screens.CartScreen.route, enterTransition = { fadeIn(tween(500))}, exitTransition = { fadeOut(tween(500))}) {
                CartScreen(navController)
            }
            composable(route = Screens.ProfileScreen.route, enterTransition = { fadeIn(tween(500))}, exitTransition = { fadeOut(tween(500))}) {
                ProfileScreen(navController)
            }
            composable(route = Screens.FavouritesScreen.route, enterTransition = { fadeIn(tween(500))}, exitTransition = { fadeOut(tween(500))}) {
                FavouritesScreen(navController)
            }
            composable(
                route = "productDetails/{productId}",
                enterTransition = {
                    slideIntoContainer(
                        AnimatedContentTransitionScope.SlideDirection.Up,
                        tween(1000)
                    )
                },
                exitTransition = {
                    slideOutOfContainer(
                        AnimatedContentTransitionScope.SlideDirection.Down,
                        tween(1000)
                    )
                },
                //fetches the relevant master view to the products
                arguments = listOf(navArgument("productId") { type = NavType.StringType })
            ) { navBackStackEntry ->
                val productId = navBackStackEntry.arguments?.getString("productId") ?: ""
                ProductDetails(productId = productId, navController = navController)
            }
        }
    }
}
