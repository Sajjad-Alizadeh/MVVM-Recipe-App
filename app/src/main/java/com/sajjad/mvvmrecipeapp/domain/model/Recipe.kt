package com.sajjad.mvvmrecipeapp.domain.model

data class Recipe(
    val id: Int? = null,
    val title: String? = null,
    val publisher: String? = null,
    val featuredImage: String? = null,
    val rating: Int? = null,
    val description: String? = null,
    val cookingInstructions: String? = null,
    val ingredients: List<String> = emptyList(),
    val dateAdded: String? = null,
    val dateUpdated: String? = null,
    val sourceUrl: String? = null,
    val longDateAdded: Int? = null,
    val longDateUpdated: Int? = null,
)