package com.example.android_exam.data.repository

import com.example.android_exam.data.common.response_handler.HandleResponse
import com.example.android_exam.data.common.Resource
import com.example.android_exam.data.mapper.base.asResource
import com.example.android_exam.data.mapper.wallpaper_details.toDomain
import com.example.android_exam.data.service.WallpaperApiService
import com.example.android_exam.domain.model.GetImage
import com.example.android_exam.domain.repository.SingleImageRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SingleImageRepositoryImpl @Inject constructor(private val wallpaperApiService: WallpaperApiService, private val handleResponse: HandleResponse):
    SingleImageRepository {
    override suspend fun getImageById(apiKey: String, id: Long): Flow<Resource<GetImage>> {
        return handleResponse.safeApiCall {
            wallpaperApiService.getImageById(apiKey, id)
        }.asResource {
            it.hits.first().toDomain()
        }
    }
}