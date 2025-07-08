package com.example.android_exam.di

import com.example.android_exam.data.common.response_handler.HandleResponse
import com.example.android_exam.data.repository.SingleImageRepositoryImpl
import com.example.android_exam.data.repository.WallpaperRepositoryImpl
import com.example.android_exam.data.service.WallpaperApiService
import com.example.android_exam.domain.repository.SingleImageRepository
import com.example.android_exam.domain.repository.WallpaperRepository
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