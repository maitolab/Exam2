package com.example.exam2.data.response

import com.google.gson.annotations.SerializedName

data class DtoRecipeResponse(
    @SerializedName("name")
    val name: String?,
    @SerializedName("headline")
    val headline: String?,
    @SerializedName("thumb")
    val thumb: String?,
    @SerializedName("calories")
    val calories: String?,
    @SerializedName("difficulty")
    val difficulty: Int?,
    @SerializedName("description")
    val description: String?,
    @SerializedName("proteins")
    val proteins: String?
)