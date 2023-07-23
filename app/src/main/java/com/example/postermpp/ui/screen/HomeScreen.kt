package com.example.postermpp.ui.screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel

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

   LazyColumn(modifier = modifier.fillMaxSize()) {
      items(state.showSuccess) {
         Text(text = "Tv Show")
         LazyRow(modifier = modifier.fillMaxSize()) {
            items(state.showSuccess) {
               Text(text = it.name)
            }
         }
      }
   }
}

