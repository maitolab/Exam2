package com.example.exam2.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.exam2.domain.Recipe
import com.example.exam2.repository.Repository
import com.example.exam2.repository.ResultWrapper
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: Repository) : ViewModel() {
    val state = MutableStateFlow<ResultWrapper<List<Recipe>>>(ResultWrapper.None)
    lateinit var selectedRecipe: Recipe
    fun getRecipe() {
        viewModelScope.launch {
            state.value = ResultWrapper.Loading
            state.value = repository.getRecipe()
        }
    }

}