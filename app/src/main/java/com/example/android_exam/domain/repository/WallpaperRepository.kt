package com.example.android_exam.domain.repository

import androidx.paging.PagingData
import com.example.android_exam.domain.model.GetImage
import kotlinx.coroutines.flow.Flow

interface WallpaperRepository {
    suspend fun getImagesByFilter(query: String, category: String): Flow<PagingData<GetImage>>
    suspend fun getImages(): Flow<PagingData<GetImage>>
}