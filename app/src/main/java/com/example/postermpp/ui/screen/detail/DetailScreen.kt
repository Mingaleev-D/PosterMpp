package com.example.postermpp.ui.screen.detail

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import coil.request.ImageRequest

/**
 * @author : Mingaleev D
 * @data : 26.07.2023
 */

@Composable
fun DetailScreen(
    viewModel: DetailViewModel = hiltViewModel(),
    modifier: Modifier = Modifier,
    onBack: () -> Unit
) {
   val state = viewModel.statedgs
   Box(
       modifier = modifier.fillMaxSize(),
       contentAlignment = Alignment.Center
   ) {
      if (state.products != null) {
         AsyncImage(
             model = ImageRequest.Builder(LocalContext.current)
                 .data(state.products.image)
                 .crossfade(true)
                 .build(),
             contentDescription = null,
             modifier = Modifier.fillMaxSize(),
             contentScale = ContentScale.FillBounds
         )

      }

      IconButton(
          onClick = { onBack() },
          modifier = Modifier.align(Alignment.TopStart)
      ) {
         Icon(
             imageVector = Icons.Default.ArrowBack,
             contentDescription = null,
             tint = Color.Green
         )
      }
      if (state.isLoading) {
         CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
      }
   }
}