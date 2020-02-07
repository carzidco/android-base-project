package com.base.application.entity.error

import com.google.gson.annotations.SerializedName

data class Unauthorized(@SerializedName("message") val message: String)
data class Authentication(@SerializedName("error") val error: String)