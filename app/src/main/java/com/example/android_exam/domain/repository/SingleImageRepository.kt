package com.example.android_exam.domain.repository

import com.example.android_exam.domain.model.GetImage
import com.example.android_exam.data.common.Resource
import kotlinx.coroutines.flow.Flow

interface SingleImageRepository {
    suspend fun getImageById(apiKey: String, id: Long): Flow<Resource<GetImage>>
}