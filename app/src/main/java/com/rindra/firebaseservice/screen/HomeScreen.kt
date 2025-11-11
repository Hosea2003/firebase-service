package com.rindra.firebaseservice.screen

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.rindra.firebaseservice.viewmodel.AuthViewModel
import kotlinx.serialization.Serializable

@Serializable
object HomeScreenRoute

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    authViewModel: AuthViewModel
) {
    
}