package com.sajjad.mvvmrecipeapp.di

import com.google.gson.Gson
import com.sajjad.mvvmrecipeapp.network.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    @Named(BASE_URL)
    fun provideBaseUrl(): String {
        return "https://food2fork.ca/api/recipe/"
    }

    @Provides
    @Singleton
    fun provideGson(): Gson {
        return Gson().newBuilder().create()
    }

    @Provides
    @Singleton
    fun provideTimeOutValue(): Long {
        return 30L
    }

    @Provides
    @Singleton
    fun provideTimeUnit(): TimeUnit {
        return TimeUnit.SECONDS
    }

    @Provides
    @Singleton
    fun provideLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor(HttpLoggingInterceptor.Logger.DEFAULT).apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    }

    @Provides
    @Singleton
    fun provideHttpClient(
        timeout: Long,
        timeUnit: TimeUnit,
        loggingInterceptor: HttpLoggingInterceptor,
    ): OkHttpClient {
        return OkHttpClient().newBuilder()
            .readTimeout(timeout, timeUnit)
            .writeTimeout(timeout, timeUnit)
            .connectTimeout(timeout, timeUnit)
            .retryOnConnectionFailure(true)
            .addInterceptor(loggingInterceptor)
            .addInterceptor {
                val oldRequest = it.request()

                val newRequest = oldRequest.newBuilder()
                    .addHeader("Authorization", "Token 9c8b06d329136da358c2d00e76946b0111ce2c48")
                    .method(oldRequest.method, oldRequest.body)

                return@addInterceptor it.proceed(newRequest.build())
            }
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(
        @Named(BASE_URL) baseUrl: String,
        client: OkHttpClient,
        gson: Gson,
    ): ApiService {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(client)
            .build()
            .create(ApiService::class.java)
    }
}