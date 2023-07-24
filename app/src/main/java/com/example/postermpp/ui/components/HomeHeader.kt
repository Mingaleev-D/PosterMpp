package com.example.postermpp.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.unit.dp
import com.example.postermpp.R

/**
 * @author : Mingaleev D
 * @data : 24.07.2023
 */

@Composable
fun HomeHeader(
    modifier: Modifier = Modifier
) {
   Box(
       modifier = modifier.fillMaxWidth().height(90.dp),
       contentAlignment = Alignment.Center
   ) {
      Image(
          painter = painterResource(id = R.drawable.tvone),
          contentDescription = null,
          modifier = Modifier.padding(top = 18.dp)
      )
      // TODO: next code.
   }
}