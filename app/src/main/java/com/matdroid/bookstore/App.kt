package com.matdroid.bookstore

import android.app.Application
import android.arch.persistence.room.Room
import timber.log.Timber
import com.matdroid.bookstore.database.AppDatabase
import com.matdroid.bookstore.database.DATABASE_NAME
import com.matdroid.bookstore.repository.BookRepository

class App : Application() {

    companion object {
        lateinit var db: AppDatabase
        lateinit var repository: BookRepository
    }

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
        db = Room.databaseBuilder(this,
                AppDatabase::class.java, DATABASE_NAME)
                .build()

        repository = BookRepository()
        repository.scheduleBooksSync()
    }
}