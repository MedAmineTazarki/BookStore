package com.matdroid.bookstore.bookslist

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import com.matdroid.bookstore.App
import com.matdroid.bookstore.Book

class BooksListViewModel : ViewModel() {

    val books : LiveData<List<Book>> = App.db.bookDao().getAllBooks()

    fun refreshBooks() {
        App.repository.syncBooksNow()
    }
}