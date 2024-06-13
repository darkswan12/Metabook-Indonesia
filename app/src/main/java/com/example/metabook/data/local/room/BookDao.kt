package com.example.metabook.data.local.room

import androidx.lifecycle.LiveData
import androidx.room.*


@Dao
interface BookDao {
    @Query("SELECT * FROM Book")
    fun getAllBookmark(): LiveData<List<Book>>

    @Insert
    suspend fun addBookmark(book: Book)

    @Delete
    suspend fun deleteBookmark(book: Book)
}