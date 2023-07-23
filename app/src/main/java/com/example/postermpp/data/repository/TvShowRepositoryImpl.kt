package com.example.postermpp.data.repository

import com.example.postermpp.data.mapper.toDomain
import com.example.postermpp.data.remote.ApiService
import com.example.postermpp.domain.model.TvShowModel
import com.example.postermpp.domain.repository.TVShowRepository

/**
 * @author : Mingaleev D
 * @data : 23.07.2023
 */

class TvShowRepositoryImpl(
    private val api: ApiService
) : TVShowRepository {
   override suspend fun getTvShow(): List<TvShowModel> {
      return api.getTvShow().map { it.toDomain() }
   }
}