package com.example.androidproject.domain.usecase.wallpaper_details

import com.example.androidproject.data.common.Resource
import com.example.androidproject.data.mapper.base.asResource
import com.example.androidproject.presentation.mapper.toPresenter
import com.example.androidproject.domain.repository.SingleImageRepository
import com.example.androidproject.presentation.model.Image
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetWallpaperDetailsUseCase @Inject constructor(private val wallpaperDetailsRepository: SingleImageRepository) {
    suspend operator fun invoke(apiKey: String, id: Long): Flow<Resource<Image>> {
        return wallpaperDetailsRepository.getImageById(apiKey, id).asResource { it.toPresenter() }
    }
}