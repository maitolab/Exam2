package com.example.exam2.repository

import com.example.exam2.data.Api
import com.example.exam2.domain.Recipe
import com.example.exam2.mapper.toDomain
import java.lang.Exception

class Repository(private val api: Api) {
    suspend fun getRecipe(): ResultWrapper<List<Recipe>> {
        return try {
            val response = api.getRecipe().orEmpty().map { it.toDomain() }
            ResultWrapper.Success(response)
        } catch (e: Exception) {
            ResultWrapper.Error(e)
        }
    }
}