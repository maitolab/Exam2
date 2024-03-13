package com.example.exam2.mapper

import com.example.exam2.data.response.DtoRecipeResponse
import com.example.exam2.domain.Recipe

fun DtoRecipeResponse.toDomain() = Recipe(
    name = name.orEmpty(),
    headline = headline.orEmpty(),
    thumb = thumb.orEmpty(),
    calories = calories.orEmpty(),
    difficulty = difficulty ?: 0,
    description = description.orEmpty(),
    proteins = proteins.orEmpty()
)