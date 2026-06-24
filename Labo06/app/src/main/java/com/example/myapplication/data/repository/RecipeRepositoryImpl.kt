package com.example.myapplication.data.repository


import com.example.myapplication.data.api.KtorClient
import com.example.myapplication.data.api.recipes.RecipeResponseDto
import com.example.myapplication.data.api.recipes.toModel
import com.example.myapplication.data.model.Recipe
import io.ktor.client.call.body
import io.ktor.client.request.get

class RecipeRepositoryImpl : RecipeRepository {
    override suspend fun getRecipes(): Result<List<Recipe>> {
        return try {
            val response = KtorClient.client
                .get("https://www.themealdb.com/api/json/v1/1/search.php?s=")
                .body<RecipeResponseDto>()
            val recipes = response.meals?.map { it.toModel() } ?: emptyList()
            Result.success(recipes)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}