package com.example.postermpp.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.postermpp.domain.model.ProductsModel
import com.example.postermpp.ui.components.HomeChip
import com.example.postermpp.ui.components.HomeHeader
import com.example.postermpp.ui.components.HomeProductsPoster
import com.example.postermpp.ui.components.ProductPosterSize
import com.example.postermpp.ui.components.TvShowPoster

/**
 * @author : Mingaleev D
 * @data : 23.07.2023
 */

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel(),
    onProductClick: (ProductsModel) -> Unit
) {

   val state = viewModel.state

   LazyVerticalGrid(
       columns = GridCells.Fixed(2),
       modifier = Modifier
           .fillMaxSize()
           .padding(start = 20.dp, end = 20.dp),
       verticalArrangement = Arrangement.spacedBy(16.dp),
       horizontalArrangement = Arrangement.spacedBy(16.dp)
   ) {

      item(span = {
         GridItemSpan(2)
      }) {
         HomeHeader()
      }

      if (state.productsSuccess.isNotEmpty()) {
         item(span = {
            GridItemSpan(2)
         }) {
            TvShowPoster(
                title = "Products",
                products = state.productsSuccess
            ){
               onProductClick(it)
            }
         }
      }

      if (state.electroSuccess.isNotEmpty()) {
         item(span = {
            GridItemSpan(2)
         }) {
            TvShowPoster(
                title = "Electronics",
                products = state.electroSuccess
            ){
               onProductClick(it)
            }
         }
      }

      if (state.filteredProducts.isNotEmpty()) {
         item(span = {
            GridItemSpan(2)
         }) {
            Spacer(modifier = Modifier.height(16.dp))
            HomeChip(
                selectedFilter = state.selectedFilter,
                onFilterClick = {
                   viewModel.onEvent(HomeEvent.ChangeFilter(it))
                })
         }
      }

      items(state.filteredProducts) {
         HomeProductsPoster(imageUrl = it.image, posterSize = ProductPosterSize.BIG){
            onProductClick(it)
         }
      }
   }

   if (state.isLoading) {
      Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
         CircularProgressIndicator(color = Color.Red)
      }
   }
}

