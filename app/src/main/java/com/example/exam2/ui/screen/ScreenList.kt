package com.example.exam2.ui.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.exam2.repository.ResultWrapper
import com.example.exam2.ui.activityHiltViewModel
import com.example.exam2.ui.component.RecipeItem
import com.example.exam2.viewmodel.MainViewModel

@Composable
fun ScreenList(onRecipeSelected: () -> Unit) {
    val viewModel = activityHiltViewModel<MainViewModel>()
    when (val result = viewModel.state.collectAsStateWithLifecycle().value) {
        is ResultWrapper.Loading -> {
            Box(modifier = Modifier.fillMaxSize()) {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            }
        }

        is ResultWrapper.Error -> Text(text = result.throwable?.message.orEmpty())
        is ResultWrapper.Success -> LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(result.value) {
                RecipeItem(recipe = it, onClick = {
                    viewModel.selectedRecipe = it
                    onRecipeSelected()
                })
                HorizontalDivider()
            }
        }

        else -> {}
    }
    LaunchedEffect(Unit) {
        viewModel.getRecipe()
    }
}