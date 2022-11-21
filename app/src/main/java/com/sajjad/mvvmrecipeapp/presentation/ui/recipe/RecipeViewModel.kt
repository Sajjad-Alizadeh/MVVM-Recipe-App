package com.sajjad.mvvmrecipeapp.presentation.ui.recipe

import com.sajjad.mvvmrecipeapp.common.BaseViewModel
import com.sajjad.mvvmrecipeapp.repository.RecipeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RecipeViewModel @Inject constructor(
    private val repository: RecipeRepository
): BaseViewModel()