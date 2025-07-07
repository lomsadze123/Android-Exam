package com.example.androidproject.di

import com.example.androidproject.data.common.response_handler.HandleResponse
import com.example.androidproject.data.repository.SingleImageRepositoryImpl
import com.example.androidproject.data.repository.WallpaperRepositoryImpl
import com.example.androidproject.data.service.WallpaperApiService
import com.example.androidproject.domain.repository.SingleImageRepository
import com.example.androidproject.domain.repository.WallpaperRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideWallpaperRepository(wallpaperApiService: WallpaperApiService): WallpaperRepository =
        WallpaperRepositoryImpl(apiService = wallpaperApiService)

    @Singleton
    @Provides
    fun provideSingleImageRepository(
        wallpaperApiService: WallpaperApiService,
        handleResponse: HandleResponse
    ): SingleImageRepository =
        SingleImageRepositoryImpl(
            wallpaperApiService = wallpaperApiService,
            handleResponse = handleResponse
        )

}