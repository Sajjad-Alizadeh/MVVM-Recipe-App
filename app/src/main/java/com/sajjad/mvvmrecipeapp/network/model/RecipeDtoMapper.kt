package com.sajjad.mvvmrecipeapp.network.model

import com.sajjad.mvvmrecipeapp.domain.model.Recipe
import com.sajjad.mvvmrecipeapp.domain.utils.DomainMapper
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RecipeDtoMapper @Inject constructor() : DomainMapper<RecipeDto, Recipe> {
    override fun mapToDomainModel(entity: RecipeDto): Recipe {
        return Recipe(
            id = entity.id,
            title = entity.title,
            publisher = entity.publisher,
            featuredImage = entity.featuredImage,
            rating = entity.rating,
            description = entity.description,
            cookingInstructions = entity.cookingInstructions,
            ingredients = entity.ingredients ?: emptyList(),
            dateAdded = entity.dateAdded,
            dateUpdated = entity.dateUpdated
        )
    }

    override fun mapFromDomainModel(domainModel: Recipe): RecipeDto {
        return RecipeDto(
            id = domainModel.id,
            title = domainModel.title,
            publisher = domainModel.publisher,
            featuredImage = domainModel.featuredImage,
            rating = domainModel.rating,
            description = domainModel.description,
            cookingInstructions = domainModel.cookingInstructions,
            ingredients = domainModel.ingredients,
            dateAdded = domainModel.dateAdded,
            dateUpdated = domainModel.dateUpdated,
            sourceUrl = domainModel.sourceUrl,
            longDateAdded = domainModel.longDateAdded,
            longDateUpdated = domainModel.longDateUpdated
        )
    }

    override fun toDomainModelList(initial: List<RecipeDto>): List<Recipe> {
        return initial.map { mapToDomainModel(it) }
    }

    override fun fromDomainModelList(initial: List<Recipe>): List<RecipeDto> {
        return initial.map { mapFromDomainModel(it) }
    }
}