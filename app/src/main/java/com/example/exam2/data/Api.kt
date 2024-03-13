package com.example.exam2.data

import com.example.exam2.data.response.DtoRecipeResponse
import retrofit2.http.GET

interface Api {
    @GET("android-test/recipes.json")
    suspend fun getRecipe():List<DtoRecipeResponse>?
}