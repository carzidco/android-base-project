package com.base.application.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.util.*

@Entity
data class AccessToken(
    @PrimaryKey
    @SerializedName("access_token") val accessToken: String,
    @SerializedName("refresh_token") val refreshToken: String,
    @SerializedName("token_type") val token_type: String,
    @SerializedName("expires_in") val expiresIn: Int,
    @SerializedName("expires_at") var expiresAt: Date
) {
    fun isExpired(): Boolean = Date().after(expiresAt)
}