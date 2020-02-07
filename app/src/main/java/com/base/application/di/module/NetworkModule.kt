package com.base.application.di.module

import com.google.gson.*
import com.legalshield.retrobomb.RetrobombInterceptor
import com.base.application.di.Constants
import com.base.application.network.Endpoint
import dagger.Module
import dagger.Provides
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.text.SimpleDateFormat
import java.util.*

@Module
class NetworkModule(private val apiRepository: Endpoint?) {

    @Provides
    fun providesWalletRepository(): Endpoint {

        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        val client = OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .addInterceptor(RetrobombInterceptor(Endpoint::class.java))
            .build()

        val gson = GsonBuilder().registerTypeAdapter(Date::class.java, JsonSerializer<Date> { date: Date?, _, context ->
            val parsed = date?.toString("yyyy-MM-dd'T'HH:mm:ss'Z'")
            if (parsed == null) null
            else context?.serialize(parsed)

        }).registerTypeAdapter(Date::class.java, JsonDeserializer<Date> { json: JsonElement?, _, _ ->
            json?.asString?.toDate("yyyy-MM-dd'T'HH:mm:ss'Z'")
        }).registerTypeAdapter(Boolean::class.java, JsonDeserializer<Boolean> { json: JsonElement?, _, _ ->
            json?.asInt == 1
        }).create()

        return apiRepository?:Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
            .client(client)
            .build().create(Endpoint::class.java)
    }

    @Provides
    fun providesGSON() = Gson()
}

fun Date.toString(mask: String): String? {
    return try {
        val simpleDateFormat = SimpleDateFormat(mask, Locale.getDefault())
        simpleDateFormat.format(this)
    } catch (ignored: Exception) {
        null
    }
}

fun String.toDate(mask: String): Date? {
    return try {
        val simpleDateFormat = SimpleDateFormat(mask, Locale.getDefault())
        simpleDateFormat.parse(this)
    } catch (ignored: Exception) {
        null
    }
}