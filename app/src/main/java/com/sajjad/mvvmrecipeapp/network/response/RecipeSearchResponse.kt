package com.sajjad.mvvmrecipeapp.network.response

import com.sajjad.mvvmrecipeapp.network.model.RecipeDto

data class RecipeSearchResponse(
    val count: Int? = null,
    val recipes: List<RecipeDto>,
)