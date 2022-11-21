package com.sajjad.mvvmrecipeapp.repository

import com.sajjad.mvvmrecipeapp.domain.model.Recipe

interface RecipeRepository {
    suspend fun searchRecipe(q: String?, page: Int): List<Recipe>
    suspend fun recipeDetail(id: Int): Recipe
}