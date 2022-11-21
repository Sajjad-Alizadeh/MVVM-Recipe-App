package com.sajjad.mvvmrecipeapp.presentation.navigation.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun RecipeListScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            style = TextStyle(color = Color.Black, fontSize = 30.sp),
            text = "...Recipe list screen..."
        )
        Spacer(modifier = Modifier.height(20.dp))




        Button(onClick = {
            navController.navigate(
                route = Screen.Recipe.withArgs("Android")
            )
        }) {
            Text(text = "Navigate to recipe screen")
        }




    }
}