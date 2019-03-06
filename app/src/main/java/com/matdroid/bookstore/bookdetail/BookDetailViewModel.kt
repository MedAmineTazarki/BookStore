package com.matdroid.bookstore.bookdetail

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Transformations
import android.arch.lifecycle.ViewModel
import com.matdroid.bookstore.App
import com.matdroid.bookstore.Book

class BookDetailViewModel(bookId: Int) : ViewModel() {
    private val bookIdLiveData = MutableLiveData<Int>()

    val book : LiveData<Book> = Transformations.switchMap(bookIdLiveData) { id ->
        App.db.bookDao().getBookById(id)
    }

    init {
        bookIdLiveData.value = bookId
    }
}