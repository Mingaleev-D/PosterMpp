package com.example.postermpp.data.ext

import kotlinx.coroutines.CancellationException
import retrofit2.HttpException

/**
 * @author : Mingaleev D
 * @data : 24.07.2023
 */

inline fun <T, R> T.resultOf(block: T.() -> R): Result<R> {
   return try {
      Result.success(block())
   } catch (e: CancellationException) {
      throw e
   } catch (e: HttpException) {
      Result.failure(e)
   } catch (e: Exception) {
      Result.failure(e)
   }
}