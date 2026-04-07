package com.example.loginapp

import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.navigation.compose.*
import androidx.navigation.compose.rememberNavController

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost (
        navController = navController,
        startDestination = "home"
    ) {
        composable("home") {
            HomeScreen(navController)
        }
        composable("register"){
            RegisterScreen(navController)
        }
        composable("login") {
            LoginScreen(navController)
        }
    }
}