package com.example.postermpp.ui.screen.detail

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.FilterQuality.Companion.Medium
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.postermpp.ui.screen.detail.components.DetailDescriptor

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
         Column(
             modifier = Modifier.fillMaxWidth().align(Alignment.BottomCenter),
             horizontalAlignment = Alignment.CenterHorizontally,
             verticalArrangement = Arrangement.SpaceEvenly
         ) {
            Text(
                text = state.products.category,
                fontWeight = FontWeight.SemiBold,
                fontSize = 40.sp,
                color = Color(0xFFE7430F)
            )
            Row(verticalAlignment = Alignment.CenterVertically) {
               DetailDescriptor(
                   text = "price: ${state.products.price} $",
                   backgroundColor = Color.LightGray
               )
               Spacer(modifier = Modifier.width(8.dp))
               DetailDescriptor(
                   text = state.products.rating.toString(),
                   backgroundColor = Color.Yellow,
                   image = Icons.Default.Star
               )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                modifier = Modifier
                    .padding(start = 20.dp, end = 20.dp)
                    .border(BorderStroke(2.dp, Color(0xFFD500F9))),
                text = state.products.title,
                color = Color(0xFFD500F9),
                fontSize = 24.sp
            )
            Spacer(modifier = Modifier.height(16.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .border(.2.dp, Color(0xFFE7430F), RoundedCornerShape(12.dp))
                    .padding(vertical = 16.dp),
                contentAlignment = Alignment.Center
            ) {
               Text(
                   text = "manufacturer's website",
                   color = Color(0xFFE7430F),
                   fontSize = 24.sp,
                   fontWeight = FontWeight.Medium
               )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Column(horizontalAlignment = Alignment.Start) {
               Text(
                   text = "DESCRIPTION: ", fontSize = 24.sp,
                   fontWeight = FontWeight.Bold, color = Color(0xFFD500F9)
               )
               Text(
                   text = state.products.description, fontSize = 14.sp,
                   fontWeight = FontWeight.Light, color = Color(0xFFE7430F)
               )
            }
         }
      }

      Box(
          modifier = Modifier
              .fillMaxSize()
              .background(
                  Brush.verticalGradient(
                      colors = listOf(
                          Color.Black,
                          Color.Transparent,
                          Color.Black.copy(alpha = 0.6f)
                      ), tileMode = TileMode.Clamp
                  )
              )
      ) {

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