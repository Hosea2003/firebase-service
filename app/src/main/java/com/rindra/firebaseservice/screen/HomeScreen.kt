package com.rindra.firebaseservice.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
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
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Button(
            onClick = {
                authViewModel.signOut()
                navController.navigate(LoginScreenRoute)
            }
        ) {
            Text(text = "Sign out")
        }
    }
}