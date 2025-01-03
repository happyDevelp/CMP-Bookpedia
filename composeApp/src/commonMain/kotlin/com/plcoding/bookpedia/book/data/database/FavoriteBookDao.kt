package com.plcoding.bookpedia.book.data.database

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface FavoriteBookDao {

    @Upsert
    suspend fun upsert(book: BookEntity)

    @Query("select * from BookEntity")
    suspend fun getFavoriteBook(): Flow<List<BookEntity>>

    @Query("select * from BookEntity where id = :id")
    suspend fun getFavoriteBook(id: String): BookEntity?

    @Query("delete from BookEntity where id = :id")
    suspend fun deleteFavoriteBook(id: String)
}