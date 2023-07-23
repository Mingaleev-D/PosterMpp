package com.example.postermpp.data.remote

import com.example.postermpp.data.remote.dto.TvShowDtoItem
import retrofit2.http.GET

/**
 * @author : Mingaleev D
 * @data : 23.07.2023
 */

interface ApiService {

   companion object {
      const val BASE_URL = "https://api.tvmaze.com/"
   }

   @GET("shows")
   suspend fun getTvShow(): List<TvShowDtoItem>
}