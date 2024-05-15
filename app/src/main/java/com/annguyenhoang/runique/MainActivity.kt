package com.annguyenhoang.runique

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.annguyenhoang.presentation.designsystem.RuniqueTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RuniqueTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { _ ->
                    val navController = rememberNavController()
                    NavigationRoot(navController = navController)
                }
            }
        }
    }
}