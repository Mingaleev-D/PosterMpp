package com.example.postermpp.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * @author : Mingaleev D
 * @data : 25.07.2023
 */

@Composable
fun HomeChip(
    selectedFilter: FilterType,
    modifier: Modifier = Modifier,
    onFilterClick: (FilterType) -> Unit,
) {
   Column(modifier = modifier.fillMaxWidth()) {
      Text(
          text = "\"Just a ChipFilter\"", fontWeight = FontWeight.SemiBold,
          fontSize = 20.sp,
          color = Color.White
      )
      Spacer(modifier = Modifier.height(12.dp))
      FilterPillContainer(
          filter = FilterType.values().toList(),
          selectedFilter = selectedFilter,
          onFilterClick = onFilterClick
      )
   }
}