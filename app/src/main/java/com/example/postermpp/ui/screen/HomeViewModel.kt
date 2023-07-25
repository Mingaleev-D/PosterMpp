package com.example.postermpp.ui.screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.postermpp.domain.repository.ProductsRepository
import com.example.postermpp.ui.components.FilterType
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import kotlinx.coroutines.supervisorScope
import javax.inject.Inject

/**
 * @author : Mingaleev D
 * @data : 24.07.2023
 */

@HiltViewModel
class HomeViewModel @Inject constructor(
    val repository: ProductsRepository
) : ViewModel() {

   var state by mutableStateOf(HomeState())
      private set

   init {
      state = state.copy(isLoading = true)
      viewModelScope.launch {
         supervisorScope {
            val products = launch { getProducts() }
            val electro = launch { getElectro() }
            val filtered = launch { getByFilterJelOrMen() }
            listOf(products, electro, filtered).map { it.join() }
            state = state.copy(isLoading = false)
         }
      }
   }

   private suspend fun getProducts() {
      repository.getProducts().onSuccess {
         state = state.copy(
             productsSuccess = it
         )
      }.onFailure {
         println()
      }

   }

   private suspend fun getElectro() {
      repository.getElectro().onSuccess {
         state = state.copy(
             electroSuccess = it
         )
      }.onFailure {
         println()
      }
   }

   private suspend fun getByFilterJelOrMen() {
      val jobResult = when (state.selectedFilter) {
         FilterType.JEWELERY -> repository.getFilterJel()
         FilterType.MENSCLITHING -> repository.getFilterMenClo()
      }
      jobResult.onSuccess {
         state = state.copy(
             filteredProducts = it
         )
      }.onFailure {
         println()
      }
   }

   fun onEvent(event: HomeEvent) {
      when (event) {
         is HomeEvent.ChangeFilter -> {
            if (event.filterType != state.selectedFilter) {
               state = state.copy(selectedFilter = event.filterType)
               viewModelScope.launch {
                  getByFilterJelOrMen()
               }
            }
         }

         is HomeEvent.OnProductsClick -> TODO()
      }
   }
}