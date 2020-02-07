package com.base.application.di.module

import android.content.Context
import androidx.room.Room
import com.base.application.database.Database
import com.base.application.database.dao.*
import dagger.Module
import dagger.Provides

@Module
internal class DatabaseModule(
    private var authAccessTokenDao: AuthAccessTokenDao? = null
) {
    @Provides
    fun providesAuthDatabase(context: Context): Database {
        return Room.databaseBuilder(context, Database::class.java, "db").build()
    }

    @Provides
    fun providesAccessTokenDao(database: Database) = authAccessTokenDao ?: database.authAccessTokenDao().also { authAccessTokenDao = it }
}