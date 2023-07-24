package com.example.postermpp.di

import com.example.postermpp.data.remote.ApiService
import com.example.postermpp.data.remote.ApiService.Companion.BASE_URL
import com.example.postermpp.data.repository.ProductsRepositoryImpl
import com.example.postermpp.domain.repository.ProductsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AppModule {

   @Provides
   @Singleton
   fun provideApi(): ApiService {
      val client = OkHttpClient.Builder().build()
      return Retrofit
          .Builder()
          .baseUrl(BASE_URL)
          .addConverterFactory(GsonConverterFactory.create())
          .client(client)
          .build()
          .create()
   }

   @Singleton
   @Provides
   fun provideRepository(
       api: ApiService
   ): ProductsRepository {
      return ProductsRepositoryImpl(api)
   }
}