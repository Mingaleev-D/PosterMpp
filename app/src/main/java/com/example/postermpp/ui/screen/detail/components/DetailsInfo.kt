package com.example.postermpp.ui.screen.detail.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.postermpp.domain.model.ProductsDetailModel

/**
 * @author : Mingaleev D
 * @data : 26.07.2023
 */

@Composable
fun DetailsInfo(
    products: ProductsDetailModel,
    modifier: Modifier = Modifier,

) {

   Column(
       modifier = modifier
           .fillMaxWidth()
           .padding(horizontal = 14.dp),
       horizontalAlignment = Alignment.CenterHorizontally,
       verticalArrangement = Arrangement.SpaceEvenly
   ) {
      Text(
          text = products.category,
          fontWeight = FontWeight.SemiBold,
          fontSize = 40.sp,
          color = Color(0xFFE7430F)
      )
      Row(verticalAlignment = Alignment.CenterVertically) {
         DetailDescriptor(
             text = "price: ${products.price} $",
             backgroundColor = Color.LightGray
         )
         Spacer(modifier = Modifier.width(8.dp))
         DetailDescriptor(
             text = products.rating.toString(),
             backgroundColor = Color.Yellow,
             image = Icons.Default.Star
         )
      }
      Spacer(modifier = Modifier.height(8.dp))
      Text(
          modifier = Modifier
              .padding(horizontal = 10.dp)
              .border(BorderStroke(2.dp, Color(0xFFD500F9))),
          text = products.title,
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
             text = products.description, fontSize = 14.sp,
             fontWeight = FontWeight.Light, color = Color(0xFFE7430F)
         )
      }
   }
}