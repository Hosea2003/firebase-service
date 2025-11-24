package com.rindra.firebaseservice

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.rindra.firebaseservice.screen.HomeScreen
import com.rindra.firebaseservice.screen.HomeScreenRoute
import com.rindra.firebaseservice.screen.LoginScreen
import com.rindra.firebaseservice.screen.LoginScreenRoute
import com.rindra.firebaseservice.screen.SignUpScreen
import com.rindra.firebaseservice.screen.SignUpScreenRoute
import com.rindra.firebaseservice.viewmodel.AuthViewModel
import com.rindra.firebaseservice.viewmodel.HomeViewModel

@Composable
fun AppNavigation(
    modifier: Modifier = Modifier,
    authViewModel: AuthViewModel,
    homeViewModel: HomeViewModel
) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = LoginScreenRoute
    ){
        composable<LoginScreenRoute> {
            LoginScreen(modifier, navController, authViewModel)
        }
        composable<SignUpScreenRoute> {
            SignUpScreen(modifier, navController, authViewModel)
        }
        composable<HomeScreenRoute> {
            HomeScreen(modifier, navController, authViewModel, homeViewModel)
        }
    }
}