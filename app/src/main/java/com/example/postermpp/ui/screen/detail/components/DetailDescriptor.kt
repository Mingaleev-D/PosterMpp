package com.example.postermpp.ui.screen.detail.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight.Companion.Normal
import androidx.compose.ui.text.font.FontWeight.Companion.SemiBold
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * @author : Mingaleev D
 * @data : 26.07.2023
 */

@Composable
fun DetailDescriptor(
    text: String,
    backgroundColor: Color,
    modifier: Modifier = Modifier,
    image: ImageVector? = null
) {

   val textSize = if (image != null) 14.sp else 12.sp
   val textWeight = if (image != null) SemiBold else Normal
   val padding = if (image != null) PaddingValues(end = 5.dp) else PaddingValues(
       horizontal = 8.dp,
       vertical = 5.dp
   )
   Box(
       modifier = modifier
           .background(backgroundColor, RoundedCornerShape(4.dp))
           .padding(padding),
       contentAlignment = Alignment.Center
   ) {
      Row(verticalAlignment = Alignment.CenterVertically) {
         if (image != null) {
            Icon(imageVector = image, contentDescription = "icon", tint = Color.Black)
         }
         Text(text = text, fontSize = textSize, fontWeight = textWeight)
      }
   }
}

