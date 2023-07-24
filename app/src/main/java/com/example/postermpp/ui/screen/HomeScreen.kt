package com.example.postermpp.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.postermpp.R
import com.example.postermpp.ui.components.TvShowPoster

/**
 * @author : Mingaleev D
 * @data : 23.07.2023
 */

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel(),
    modifier: Modifier = Modifier
) {

   val state = viewModel.state

   LazyColumn(
       modifier = modifier
           .fillMaxSize()
           .padding(start = 24.dp)
   ) {
      if (state.showSuccess.isNotEmpty()) {
         item() {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(90.dp)
                    .padding(top = 20.dp),
                contentAlignment = Alignment.Center
            ) {
               Image(
                   painter = painterResource(id = R.drawable.tvone),
                   contentDescription = null
               )
            }
         }

         item() {
            TvShowPoster(
                title = "The TV Show",
                tvShow = state.showSuccess.map { it.image }
            )
         }
      }
      item {
         Text(text = "The actors")
      }
   }
   if (state.isLoading) {
      Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
         CircularProgressIndicator()

      }
   }
}

