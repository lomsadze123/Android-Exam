package com.example.android_exam.domain.usecase.wallpaper_details

import com.example.android_exam.data.common.Resource
import com.example.android_exam.data.mapper.base.asResource
import com.example.android_exam.presentation.mapper.toPresenter
import com.example.android_exam.domain.repository.SingleImageRepository
import com.example.android_exam.presentation.model.Image
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetWallpaperDetailsUseCase @Inject constructor(private val wallpaperDetailsRepository: SingleImageRepository) {
    suspend operator fun invoke(apiKey: String, id: Long): Flow<Resource<Image>> {
        return wallpaperDetailsRepository.getImageById(apiKey, id).asResource { it.toPresenter() }
    }
}