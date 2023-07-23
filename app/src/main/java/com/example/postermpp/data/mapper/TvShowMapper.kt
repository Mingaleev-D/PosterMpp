package com.example.postermpp.data.mapper

import com.example.postermpp.data.remote.dto.TvShowDtoItem
import com.example.postermpp.domain.model.TvShowModel

/**
 * @author : Mingaleev D
 * @data : 23.07.2023
 */

fun TvShowDtoItem.toDomain():TvShowModel{
   return TvShowModel(
              id = this.id,
              name = this.name,
              genres = this.genres,
              rating = this.rating.average,
              image = this.image.original,
              summary = this.summary,
              premiered = this.premiered
          )
       }

