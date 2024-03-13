package com.example.exam2.di

import com.example.exam2.data.Api
import com.example.exam2.repository.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Singleton
    @Provides
    fun provideOkhttpClient() = OkHttpClient.Builder().build()

    @Singleton
    @Provides
    fun provideApiService(client: OkHttpClient): Api = Retrofit.Builder()
        .baseUrl("https://hf-android-app.s3-eu-west-1.amazonaws.com/")
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(Api::class.java)

    @Singleton
    @Provides
    fun provideRepository(api: Api) = Repository(api)
}