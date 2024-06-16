package com.example.jetreader.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.jetreader.screens.SplashScreen

@Composable
fun ReaderNavigation(){
    val navController = rememberNavController()
    NavHost(navController = navController,
        startDestination = ReaderScreens.SplashScreen.name){

        composable(ReaderScreens.SplashScreen.name){
            SplashScreen(navController= navController)
        }

        composable(ReaderScreens.HomeScreen.name){
            SplashScreen(navController= navController)
        }
        composable(ReaderScreens.DetailScreen.name){
            SplashScreen(navController= navController)
        }
        composable(ReaderScreens.SplashScreen.name){
            SplashScreen(navController= navController)
        }
        composable(ReaderScreens.LoginScreen.name){
            SplashScreen(navController= navController)
        }
        composable(ReaderScreens.StatsScreen.name){
            SplashScreen(navController= navController)
        }
        composable(ReaderScreens.UpdateScreen.name){
            SplashScreen(navController= navController)
        }
        composable(ReaderScreens.SearchScreen.name){
            SplashScreen(navController= navController)
        }
        composable(ReaderScreens.CreateAccountScreen.name){
            SplashScreen(navController= navController)
        }

    }
}