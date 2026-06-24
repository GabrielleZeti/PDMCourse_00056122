package com.example.myapplication.data.api.recipes

import com.example.myapplication.data.model.Recipe
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RecipeResponseDto(
    val meals: List<RecipeDto>?
)

@Serializable
data class RecipeDto(
    @SerialName("idMeal") val idMeal: String,
    @SerialName("strMeal") val strMeal: String,
    @SerialName("strCategory") val strCategory: String,
    @SerialName("strArea") val strArea: String?,
    @SerialName("strMealThumb") val strMealThumb: String
)

fun RecipeDto.toModel(): Recipe {
    return Recipe(
        id = idMeal,
        name = strMeal,
        category = strCategory,
        area = strArea ?: "Unknown",
        imageUrl = strMealThumb
    )
}