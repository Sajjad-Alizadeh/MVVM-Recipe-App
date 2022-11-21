package com.sajjad.mvvmrecipeapp.presentation.navigation.screen

sealed class Screen(val route: String) {
    object RecipeList : Screen("recipe_list")
    object Recipe : Screen("recipe/{name}")

    fun withArgs(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }
}
