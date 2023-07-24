package com.example.postermpp.data.remote

import com.example.postermpp.BuildConfig
import com.example.postermpp.data.remote.dto.ProductsDtoItem
import retrofit2.http.GET

/**
 * @author : Mingaleev D
 * @data : 23.07.2023
 */

interface ApiService {

   companion object {
      const val BASE_URL = BuildConfig.BASE_URL
   }

   @GET("products")
   suspend fun getProducts(): List<ProductsDtoItem>
   @GET("products/category/electronics")
   suspend fun getElectroProducts(): List<ProductsDtoItem>
}