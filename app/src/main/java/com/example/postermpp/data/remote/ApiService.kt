package com.example.postermpp.data.remote

import com.example.postermpp.BuildConfig
import com.example.postermpp.data.remote.dto.ProductsDtoItem
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

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

   @GET("products/category/jewelery")
   suspend fun getFilterJewelery(): List<ProductsDtoItem>

   @GET("products/category/men's%20clothing")
   suspend fun getFiltermenClothing(): List<ProductsDtoItem>

   @GET("products/{id}")
   suspend fun getProductsDetailsId(@Path("id") id: Int):ProductsDtoItem


}