package com.baubaptest.di

import com.baubaptest.data.api.BaubapApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton
import com.baubaptest.BuildConfig

@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {

    @Provides
    @Singleton
    fun provideClient( ) : OkHttpClient {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return OkHttpClient
                        .Builder()
                        .addInterceptor(interceptor)
                        .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(client : OkHttpClient) : Retrofit {

        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }

    @Provides
    @Singleton
    fun provideBauBapApiClient(retrofit : Retrofit): BaubapApi{
        return  retrofit.create(BaubapApi::class.java)
    }

}