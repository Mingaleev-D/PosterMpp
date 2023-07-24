package com.example.postermpp.ui.screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.postermpp.domain.repository.TVShowRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * @author : Mingaleev D
 * @data : 24.07.2023
 */

@HiltViewModel
class HomeViewModel @Inject constructor(
    val repository: TVShowRepository
) : ViewModel() {

   var state by mutableStateOf(HomeState())
      private set

   init {
      state = state.copy(isLoading = true)
      getTvShow()
   }

   private fun getTvShow() {
      viewModelScope.launch {
         repository.getTvShow().onSuccess {
            state = state.copy(
                showSuccess = it
            )
         }.onFailure {
            println()
         }
         state = state.copy(isLoading = false)
      }
   }
}