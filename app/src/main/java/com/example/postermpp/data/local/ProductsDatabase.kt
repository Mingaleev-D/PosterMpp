package com.example.postermpp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

/**
 * @author : Mingaleev D
 * @data : 25.07.2023
 */

@Database(entities = [ProductsEntity::class], version = 1)
abstract class ProductsDatabase : RoomDatabase() {
   abstract val dao:ProductsDao
}