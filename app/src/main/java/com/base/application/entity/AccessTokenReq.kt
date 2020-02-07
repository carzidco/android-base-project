package com.base.application.entity

import com.google.gson.annotations.SerializedName

data class AccessTokenReq(
    @SerializedName("grant_type") val grantType: String? = null,
    @SerializedName("client_id") val clientId: String,
    @SerializedName("client_secret") val clientSecret: String? = null,
    @SerializedName("provider") val provider: String? = null,
    @SerializedName("access_token") val token: String? = null
) {
    enum class AuthenticationType {
        @SerializedName("social") Social,
        @SerializedName("password") Credentails
    }

    enum class Provider {
        @SerializedName("facebook") Facebook,
    }
}