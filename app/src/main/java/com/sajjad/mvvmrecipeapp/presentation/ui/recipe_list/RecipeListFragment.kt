package com.sajjad.mvvmrecipeapp.presentation.ui.recipe_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.material.Text
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.viewModels
import com.sajjad.mvvmrecipeapp.common.BaseFragment

class RecipeListFragment : BaseFragment() {
    private val viewModel: RecipeListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                Text("Recipe fragment")
                viewModel.recipes.value.forEach {
                    it.id
                }
            }
        }
    }
}