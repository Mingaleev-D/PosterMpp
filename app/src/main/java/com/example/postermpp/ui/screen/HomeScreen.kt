package com.example.postermpp.ui.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.postermpp.ui.components.HomeChip
import com.example.postermpp.ui.components.HomeHeader
import com.example.postermpp.ui.components.TvShowPoster

/**
 * @author : Mingaleev D
 * @data : 23.07.2023
 */

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel(),
) {

   val state = viewModel.state
   LazyColumn(
       modifier = Modifier
           .fillMaxSize()
           .padding(start = 25.dp)
   ) {
      item {
         HomeHeader()
      }

      if (state.productsSuccess.isNotEmpty()) {
         item {
            TvShowPoster(
                title = "Products",
                products = state.productsSuccess.map { it.image }
            )
         }
      }
      item {
         Spacer(modifier = Modifier.height(16.dp))
      }
      if (state.electroSuccess.isNotEmpty()) {
         item {
            TvShowPoster(
                title = "Electronics",
                products = state.electroSuccess.map { it.image }
            )
         }
      }
      item {
         Spacer(modifier = Modifier.height(16.dp))
         //         Text(
         //             text = "Just a chip", fontWeight = FontWeight.SemiBold,
         //             fontSize = 20.sp,
         //             color = Color.White
         //         )
         HomeChip(
             selectedFilter = state.selectedFilter,
             onFilterClick = {
                viewModel.onEvent(HomeEvent.ChangeFilter(it))
             },
             productsList = state.filteredProducts
         ) {

         }
      }
   }
   if (state.isLoading) {
      Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
         CircularProgressIndicator()
      }
   }
}

