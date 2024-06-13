package com.example.metabook.view.main.ui.bookmark

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.metabook.data.local.BookRepository

class BookmarkViewModel(application: Application): AndroidViewModel(application) {
    var repository: BookRepository = BookRepository(application)

    fun getBookmark() = repository.getBookmark()
}