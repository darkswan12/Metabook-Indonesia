package com.example.metabook.view.main.ui.detailbook

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.metabook.data.BooksResponse
import com.example.metabook.data.ItemsItem
import com.example.metabook.data.local.BookRepository
import com.example.metabook.data.local.room.Book
import com.example.metabook.helper.constant
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DetailViewModel(application: Application): AndroidViewModel(application) {
    var repository: BookRepository = BookRepository(application)
    var booksResponse = MutableLiveData<BooksResponse>()
    var recentBooksResponse = MutableLiveData<ItemsItem>()
    fun saveRecentBookId(id: String){
        repository.putPrefString(constant.PREF_RECENT_BOOK_ID, id)
    }
    fun getRecentBookId():String? {
        return repository.getPrefString(constant.PREF_RECENT_BOOK_ID)
    }

    fun addBookmark(book: Book){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addBookmark(book)
        }
    }

    fun deleteBookmark(book: Book){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteBookmark(book)
        }
    }

    fun getSimiliarBooks(books: String) {
        repository.getBookByQuery({
            booksResponse.value = it
        }, {}, books)
    }

    fun getBooksById(id: String) {
        repository.getBookById({
            recentBooksResponse.value = it
        }, {}, id)
    }

}