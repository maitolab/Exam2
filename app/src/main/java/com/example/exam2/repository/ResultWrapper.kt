package com.example.exam2.repository

sealed class ResultWrapper<out T> {
    data class Success<out T>(val value: T) : ResultWrapper<T>()

    data class Error(val throwable: Throwable? = null) : ResultWrapper<Nothing>()

    object None : ResultWrapper<Nothing>()

    object Loading : ResultWrapper<Nothing>()
}

