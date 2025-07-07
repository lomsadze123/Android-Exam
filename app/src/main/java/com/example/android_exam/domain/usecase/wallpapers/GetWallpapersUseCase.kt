package com.example.androidproject.domain.usecase.wallpapers

import androidx.paging.PagingData
import androidx.paging.map
import com.example.androidproject.presentation.mapper.toPresenter
import com.example.androidproject.domain.repository.WallpaperRepository
import com.example.androidproject.presentation.model.Image
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetWallpapersUseCase @Inject constructor(private val wallpaperRepository: WallpaperRepository) {
    suspend operator fun invoke() : Flow<PagingData<Image>> {
        return wallpaperRepository.getImages().map {it.map { it.toPresenter() }}
    }
}