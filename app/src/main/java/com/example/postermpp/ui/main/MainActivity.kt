package com.example.postermpp.ui.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.postermpp.ui.screen.HomeScreen
import com.example.postermpp.ui.theme.Background
import com.example.postermpp.ui.theme.PosterMppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
   override fun onCreate(savedInstanceState: Bundle?) {
      super.onCreate(savedInstanceState)
      installSplashScreen()
      setContent {
         PosterMppTheme {
            Surface(modifier = Modifier.fillMaxSize(), color = Background) {
               val navController = rememberNavController()
               NavHost(navController = navController, startDestination = "HOME") {
                  composable(route = "HOME") {
                     HomeScreen()
                  }
               }

            }
         }
      }
   }
}
