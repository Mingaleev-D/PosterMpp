package com.example.postermpp.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp

/**
 * @author : Mingaleev D
 * @data : 25.07.2023
 */

@Composable
fun FilterPillContainer(
    filter: List<FilterType>,
    selectedFilter: FilterType,
    modifier: androidx.compose.ui.Modifier = androidx.compose.ui.Modifier,
    onFilterClick: (FilterType) -> Unit
) {
   LazyRow(
       modifier = modifier.fillMaxWidth(),
       horizontalArrangement = Arrangement.spacedBy(8.dp)
   ) {
      items(filter) {
         FilterPill(type = it, isSelected = selectedFilter == it) {
            onFilterClick(it)
         }
      }
   }
}