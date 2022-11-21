package com.sajjad.mvvmrecipeapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.sajjad.mvvmrecipeapp.presentation.navigation.screen.RecipeListScreen
import com.sajjad.mvvmrecipeapp.presentation.navigation.screen.RecipeScreen
import com.sajjad.mvvmrecipeapp.presentation.navigation.screen.Screen

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.RecipeList.route) {
        composable(Screen.RecipeList.route) {
            RecipeListScreen(navController)
        }
        composable(Screen.Recipe.route,
            arguments = listOf(
                navArgument(name = "name") {
                    type = NavType.StringType
                    nullable = true
                    defaultValue = "Sajjad"
                }
            )
        ) { entry ->
            RecipeScreen(name = entry.arguments?.getString("name"))
        }
    }
}