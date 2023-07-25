package com.example.postermpp.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

/**
 * @author : Mingaleev D
 * @data : 25.07.2023
 */

@Dao
interface ProductsDao {

   @Insert(onConflict = OnConflictStrategy.REPLACE)
   suspend fun insertP(products: ProductsEntity)

   @Query("SELECT * FROM products_table")
   suspend fun getProducts(): List<ProductsEntity>
}