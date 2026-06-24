package com.example.myapplication.data.repository

import com.example.myapplication.data.model.Recipe

interface RecipeRepository {
    suspend fun getRecipes(): Result<List<Recipe>>
}