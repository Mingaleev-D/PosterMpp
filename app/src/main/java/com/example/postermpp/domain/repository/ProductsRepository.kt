package com.example.postermpp.domain.repository

import com.example.postermpp.domain.model.ProductsModel

/**
 * @author : Mingaleev D
 * @data : 23.07.2023
 */

interface ProductsRepository {

   suspend fun getProducts():Result<List<ProductsModel>>
   suspend fun getElectro():Result<List<ProductsModel>>
}