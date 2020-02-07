package com.base.application.database.dao

import androidx.room.*
import com.base.application.entity.AccessToken

@Dao
abstract class AuthAccessTokenDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insert(accessToken: AccessToken)

    @Query("DELETE FROM AccessToken")
    abstract fun deleteAccessToken()

    @Query("SELECT * FROM AccessToken LIMIT 1")
    abstract fun getAccessToken() : AccessToken
}