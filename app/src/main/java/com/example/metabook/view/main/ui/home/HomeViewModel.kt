package com.example.metabook.view.main.ui.home

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.metabook.data.BooksResponse
import com.example.metabook.data.ItemsItem
import com.example.metabook.data.local.BookRepository
import com.example.metabook.helper.constant


class HomeViewModel(application: Application): AndroidViewModel(application) {

    private var repository: BookRepository = BookRepository(application)

    var booksResponse = MutableLiveData<BooksResponse>()
    var recentBooksResponse = MutableLiveData<ItemsItem>()

    fun getUserName():String? {
        return repository.getPrefString(constant.PREF_USER)
    }

    fun getRecentBookId():String? {
        return repository.getPrefString(constant.PREF_RECENT_BOOK_ID)
    }

    fun setUserName(name: String){
        repository.putPrefString(constant.PREF_USER, name)
    }

    fun getRandomBooks(books: String) {
        repository.getBookByQuery({
            booksResponse.value = it
        }, {}, books)
    }

    fun getBooksById(id: String) {
        repository.getBookById({
            recentBooksResponse.value = it
        }, {}, id)
    }

    fun getRandomBooksByCategory(category: String) {
        repository.getBookByCategory({
            booksResponse.value = it
        }, {}, category)
    }

}