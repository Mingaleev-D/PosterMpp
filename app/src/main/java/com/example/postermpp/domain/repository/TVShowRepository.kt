package com.example.postermpp.domain.repository

import com.example.postermpp.domain.model.TvShowModel

/**
 * @author : Mingaleev D
 * @data : 23.07.2023
 */

interface TVShowRepository {

   suspend fun getTvShow():Result<List<TvShowModel>>
}