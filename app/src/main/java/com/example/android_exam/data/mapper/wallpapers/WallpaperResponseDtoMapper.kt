package com.example.android_exam.data.mapper.wallpapers

import com.example.android_exam.data.mapper.wallpaper_details.toDomain
import com.example.android_exam.data.model.WallpaperResponseDto
import com.example.android_exam.domain.model.GetWallpaperResponse

fun WallpaperResponseDto.toDomain(): GetWallpaperResponse {
    return GetWallpaperResponse(
        hits = hits.map { it.toDomain() })
}