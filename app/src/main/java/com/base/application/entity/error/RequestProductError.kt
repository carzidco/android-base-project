package com.base.application.entity.error

import com.google.gson.annotations.SerializedName


data class RequestProductError(@SerializedName("message") val message: String)