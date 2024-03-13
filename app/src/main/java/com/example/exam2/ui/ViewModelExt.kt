package com.example.exam2.ui

import androidx.activity.ComponentActivity
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel

@Composable
inline fun <reified T : ViewModel> activityHiltViewModel() : T{
    val activityScope = LocalContext.current as ComponentActivity
    return hiltViewModel<T>(activityScope)
}