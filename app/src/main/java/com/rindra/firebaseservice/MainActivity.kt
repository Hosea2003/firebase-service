package com.rindra.firebaseservice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider
import com.rindra.firebaseservice.ui.theme.FirebaseServiceTheme
import com.rindra.firebaseservice.viewmodel.AuthViewModel
import com.rindra.firebaseservice.viewmodel.HomeViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val authViewModel = ViewModelProvider(this)[AuthViewModel::class]
        val homeViewModel = ViewModelProvider(this)[HomeViewModel::class]
        setContent {
            FirebaseServiceTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding->
                    AppNavigation(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding),
                        authViewModel = authViewModel,
                        homeViewModel = homeViewModel
                    )
                }
            }
        }
    }
}