package com.sajjad.mvvmrecipeapp.repository

import com.sajjad.mvvmrecipeapp.domain.model.Recipe
import com.sajjad.mvvmrecipeapp.network.ApiService
import com.sajjad.mvvmrecipeapp.network.model.RecipeDtoMapper

class RecipeRepository_Impl(
    private val apiService: ApiService,
    private val mapper: RecipeDtoMapper
): RecipeRepository {
    override suspend fun searchRecipe(q: String?, page: Int): List<Recipe> {
        val result = apiService.searchRecipe(q, page).recipes
        return mapper.toDomainModelList(result)
    }

    override suspend fun recipeDetail(id: Int): Recipe {
        val result = apiService.recipeDetail(id)
        return mapper.mapToDomainModel(result)
    }
}