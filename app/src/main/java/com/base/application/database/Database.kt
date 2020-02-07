package com.base.application.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.base.application.database.dao.*
import com.base.application.entity.*

@Database(
    version = 1,
    entities = [
        AccessToken::class
    ], exportSchema = false)
@TypeConverters(DateConverter::class)
abstract class Database: RoomDatabase() {
    abstract fun authAccessTokenDao() : AuthAccessTokenDao
}
