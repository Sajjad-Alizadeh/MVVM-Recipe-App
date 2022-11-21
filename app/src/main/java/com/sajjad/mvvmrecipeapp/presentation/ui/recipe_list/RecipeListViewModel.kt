package com.sajjad.mvvmrecipeapp.presentation.ui.recipe_list

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.viewModelScope
import com.sajjad.mvvmrecipeapp.common.BaseViewModel
import com.sajjad.mvvmrecipeapp.domain.model.Recipe
import com.sajjad.mvvmrecipeapp.repository.RecipeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RecipeListViewModel @Inject constructor(
    private val repository: RecipeRepository,
) : BaseViewModel() {
    val recipes: MutableState<List<Recipe>> = mutableStateOf(emptyList())

    fun getRecipes(q: String?) {
        viewModelScope.launch {
            val result = repository.searchRecipe(q, 1)
            recipes.value = result
        }
    }
}