package com.example.androidproject.domain.repository

import androidx.paging.PagingData
import com.example.androidproject.domain.model.GetImage
import kotlinx.coroutines.flow.Flow

interface WallpaperRepository {
    suspend fun getImagesByFilter(query: String, category: String): Flow<PagingData<GetImage>>
    suspend fun getImages(): Flow<PagingData<GetImage>>
}