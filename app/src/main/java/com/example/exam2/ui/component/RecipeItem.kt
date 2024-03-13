package com.example.exam2.ui.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.exam2.domain.Recipe
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun RecipeItem(recipe: Recipe, onClick: () -> Unit) {
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(vertical = 8.dp)
        .clickable { onClick() }) {
        GlideImage(
            modifier = Modifier
                .padding(horizontal = 8.dp)
                .size(100.dp),
            imageModel = { recipe.thumb })
        Column(modifier = Modifier.weight(1f)) {
            Text(text = recipe.name, style = MaterialTheme.typography.titleMedium, maxLines = 1)
            Text(text = recipe.headline, style = MaterialTheme.typography.bodyMedium)
            Text(
                text = recipe.calories,
                style = MaterialTheme.typography.bodyMedium
            )

            Row {
                for (i in 0 .. recipe.difficulty) {
                    Icon(
                        modifier = Modifier.size(20.dp),
                        imageVector = Icons.Default.Star,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.primary
                    )
                }
            }
        }
    }
}