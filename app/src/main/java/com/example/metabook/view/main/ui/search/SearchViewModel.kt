package com.example.metabook.view.main.ui.search

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.metabook.data.BooksResponse
import com.example.metabook.data.local.BookRepository

class SearchViewModel(application: Application) : AndroidViewModel(application) {
    private var repository: BookRepository = BookRepository(application)

    var booksResponse = MutableLiveData<BooksResponse>()

    fun searchBookWithoutTerms(query: String?) {
        query?.let {
            repository.getBookByQuery({
                booksResponse.value = it
            }, {}, it)
        }
    }

    fun searchBookInTitle(title: String) {
        repository.getBookByTitle({
            booksResponse.value = it
        }, {}, title)
    }

    fun searchBookInAuthor(author: String) {
        repository.getBookByAuthor({
            booksResponse.value = it
        }, {}, author)
    }

    fun searchBookInCategory(category: String) {
        repository.getBookByCategory({
            booksResponse.value = it
        }, {}, category)
    }

    fun searchBookInPublisher(publisher: String) {
        repository.getBookByPublisher({
            booksResponse.value = it
        }, {}, publisher)
    }
}