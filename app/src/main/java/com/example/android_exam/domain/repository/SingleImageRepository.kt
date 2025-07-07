package com.example.androidproject.domain.repository

import com.example.androidproject.data.common.Resource
import com.example.androidproject.domain.model.GetImage
import kotlinx.coroutines.flow.Flow

interface SingleImageRepository {
    suspend fun getImageById(apiKey: String, id: Long): Flow<Resource<GetImage>>
}