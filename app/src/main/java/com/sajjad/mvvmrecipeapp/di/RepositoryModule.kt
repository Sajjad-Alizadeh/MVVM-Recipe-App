package com.sajjad.mvvmrecipeapp.di

import com.sajjad.mvvmrecipeapp.network.ApiService
import com.sajjad.mvvmrecipeapp.network.model.RecipeDtoMapper
import com.sajjad.mvvmrecipeapp.repository.RecipeRepository
import com.sajjad.mvvmrecipeapp.repository.RecipeRepository_Impl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    @Singleton
    fun provideRecipeRepository(apiService: ApiService, mapper: RecipeDtoMapper): RecipeRepository {
        return RecipeRepository_Impl(apiService, mapper)
    }

}