package com.example.exam2.ui.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.exam2.ui.activityHiltViewModel
import com.example.exam2.viewmodel.MainViewModel
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun ScreenDetail(onBack: () -> Unit) {
    val viewModel = activityHiltViewModel<MainViewModel>()
    val recipe = viewModel.selectedRecipe
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            Box {
                GlideImage(
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(4f / 3),
                    imageModel = { recipe.thumb })
                IconButton(
                    modifier = Modifier
                        .align(Alignment.TopStart)
                        .padding(16.dp),
                    onClick = onBack
                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = null
                    )
                }
            }
        }
    ) { paddingValues ->
        Column(
            Modifier
                .padding(paddingValues)
                .padding(16.dp)
                .verticalScroll(rememberScrollState())
        ) {
            Text(text = recipe.name, style = MaterialTheme.typography.titleLarge)
            Text(text = recipe.headline, style = MaterialTheme.typography.titleMedium)
            Text(
                text = "${recipe.calories} - ${recipe.proteins}",
                style = MaterialTheme.typography.bodyMedium
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = recipe.description, style = MaterialTheme.typography.bodyMedium)
        }
    }
}