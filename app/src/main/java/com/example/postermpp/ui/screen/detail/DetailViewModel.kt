package com.example.postermpp.ui.screen.detail

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.postermpp.domain.repository.ProductsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * @author : Mingaleev D
 * @data : 26.07.2023
 */

@HiltViewModel
class DetailViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val repository: ProductsRepository
) : ViewModel() {

   var statedgs by mutableStateOf(DetailState())
      private set

   init {
      statedgs = statedgs.copy(
          isLoading = true
      )
      val productId = savedStateHandle.get<Int>("detail_id")
      viewModelScope.launch {
         if (productId != null) {
            repository.getProductsById(productId).onSuccess {
               statedgs = statedgs.copy(
                   products = it
               )
            }.onFailure {
               println()
            }
         }
         statedgs = statedgs.copy(
             isLoading = false
         )
      }
   }
}