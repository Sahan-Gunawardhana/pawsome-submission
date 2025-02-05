package com.example.pawsomepetcare

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.pawsomepetcare.navigation.AppNavigation
import com.example.pawsomepetcare.ui.theme.PawsomePetCareTheme
import com.example.pawsomepetcare.Authentications.AuthViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val authViewModel = AuthViewModel()

        setContent {
            PawsomePetCareTheme {
                AppNavigation(authViewModel = authViewModel)
            }
        }
    }
}
