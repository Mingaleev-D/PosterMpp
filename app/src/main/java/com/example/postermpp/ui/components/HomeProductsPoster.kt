package com.example.postermpp.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.postermpp.domain.model.ProductsModel

/**
 * @author : Mingaleev D
 * @data : 25.07.2023
 */

@Composable
fun HomeProductsPoster(
    imageUrl: String,
    posterSize: ProductPosterSize,
    onProductClick: () -> Unit
) {
   val height = if (posterSize == ProductPosterSize.SMALL) 180 else 205
   val width = if (posterSize == ProductPosterSize.SMALL) 138 else 156

   AsyncImage(
       model = ImageRequest.Builder(LocalContext.current)
           .data(imageUrl)
           .crossfade(true)
           .build(),
       contentDescription = null,
       modifier = Modifier
           .clip(RoundedCornerShape(10))
           .size(width = (width).dp, height = (height).dp)
           .clickable {
              onProductClick()
           },
       contentScale = ContentScale.FillBounds
   )
}

enum class ProductPosterSize {
   SMALL,
   BIG
}