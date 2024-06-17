package com.example.jetreader.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.jetreader.screens.SplashScreen
import com.example.jetreader.screens.login.LoginScreen
import com.example.jetreader.screens.search.SearchScreen
import com.example.jetreader.screens.stats.StatsScreen
import com.example.jetreader.screens.update.UpdateScreen

@Composable
fun ReaderNavigation(){
    val navController = rememberNavController()
    NavHost(navController = navController,
        startDestination = ReaderScreens.SplashScreen.name) {

        composable(ReaderScreens.SplashScreen.name) {
            SplashScreen(navController = navController)
        }

        composable(ReaderScreens.HomeScreen.name) {
            SplashScreen(navController = navController)
        }
        composable(ReaderScreens.DetailScreen.name) {
            SplashScreen(navController = navController)
        }
        composable(ReaderScreens.SplashScreen.name) {
            SplashScreen(navController = navController)
        }
        composable(ReaderScreens.LoginScreen.name) {
            LoginScreen(navController = navController)
        }
        composable(ReaderScreens.StatsScreen.name) {
            StatsScreen(navController = navController)
        }
        composable(ReaderScreens.UpdateScreen.name) {
            UpdateScreen(navController = navController)
        }
        composable(ReaderScreens.SearchScreen.name) {
            SearchScreen(navController = navController)
        }


    }
}