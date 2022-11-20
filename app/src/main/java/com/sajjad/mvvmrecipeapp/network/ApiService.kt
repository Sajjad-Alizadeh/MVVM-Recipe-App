package com.sajjad.mvvmrecipeapp.network

import com.sajjad.mvvmrecipeapp.network.model.RecipeNetworkEntity
import com.sajjad.mvvmrecipeapp.network.response.RecipeSearchResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("search")
    suspend fun searchRecipe(
        @Query("query") q: String,
        @Query("page") page: Int,
    ): RecipeSearchResponse

    @GET("get")
    suspend fun recipeList(
        @Query("id") id: Int
    ): RecipeNetworkEntity
}