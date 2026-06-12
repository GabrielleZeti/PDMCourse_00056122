package com.example.labo05.navigation

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

sealed interface AppRoutes : NavKey {

    @Serializable
    data object TodoList : AppRoutes

    @Serializable
    data object AddTask : AppRoutes
}