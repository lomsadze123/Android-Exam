package com.example.android_exam.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.android_exam.data.paging.WallpaperPagingSource
import com.example.android_exam.BuildConfig
import com.example.android_exam.data.paging.WallpaperPagingSource
import com.example.android_exam.data.service.WallpaperApiService
import com.example.android_exam.domain.model.GetImage
import com.example.android_exam.domain.repository.WallpaperRepository
import com.google.firebase.BuildConfig
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class WallpaperRepositoryImpl @Inject constructor(private val apiService: WallpaperApiService) :
    WallpaperRepository {
    override suspend fun getImagesByFilter(query: String, category: String): Flow<PagingData<GetImage>> =
        Pager(PagingConfig(pageSize = BuildConfig.PAGE_SIZE)) {
            WallpaperPagingSource(apiService, BuildConfig.API_KEY, query, category)
        }.flow

    override suspend fun getImages(): Flow<PagingData<GetImage>> =
        Pager(PagingConfig(pageSize = BuildConfig.PAGE_SIZE)) {
            WallpaperPagingSource(apiService, BuildConfig.API_KEY, "", "all")
        }.flow
}