package com.base.application.network

import com.legalshield.retrobomb.ErrorMapping
import com.legalshield.retrobomb.RetrobombMappings
import com.base.application.entity.AccessToken
import com.base.application.entity.AccessTokenReq
import com.base.application.entity.error.Authentication
import retrofit2.http.*

interface Endpoint {

    @RetrobombMappings(ErrorMapping(code = 403, errorType =  Authentication::class))
    @Headers("Content-Type: application/json")
    @POST("/oauth/token")
    fun authToken(@Body params: AccessTokenReq): AccessToken
}
