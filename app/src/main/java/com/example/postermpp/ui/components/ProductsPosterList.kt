package com.example.postermpp.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.postermpp.domain.model.ProductsModel

/**
 * @author : Mingaleev D
 * @data : 24.07.2023
 */

@Composable
fun TvShowPoster(
    title: String,
    products: List<ProductsModel>,
    modifier: Modifier = Modifier,
    onProductClick: (ProductsModel) -> Unit
) {
   Column(modifier = modifier) {
      Text(
          text = title,
          fontWeight = FontWeight.SemiBold,
          fontSize = 20.sp,
          color = Color.White
      )
      Spacer(modifier = Modifier.height(16.dp))
      LazyRow(
          modifier = Modifier.fillMaxWidth(),
          contentPadding = PaddingValues(horizontal = 1.dp),
          horizontalArrangement = Arrangement.spacedBy(10.dp)
      ) {
         items(products) {
            HomeProductsPoster(imageUrl = it.image, posterSize = ProductPosterSize.SMALL){
               onProductClick(it)
            }
         }
      }
   }
}