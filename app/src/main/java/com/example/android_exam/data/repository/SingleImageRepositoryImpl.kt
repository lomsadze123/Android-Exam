package com.example.androidproject.data.repository

import com.example.androidproject.data.common.response_handler.HandleResponse
import com.example.androidproject.data.common.Resource
import com.example.androidproject.data.mapper.base.asResource
import com.example.androidproject.data.mapper.wallpaper_details.toDomain
import com.example.androidproject.data.service.WallpaperApiService
import com.example.androidproject.domain.model.GetImage
import com.example.androidproject.domain.repository.SingleImageRepository
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