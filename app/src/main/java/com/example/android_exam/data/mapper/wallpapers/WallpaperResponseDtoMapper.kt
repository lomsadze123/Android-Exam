package com.example.androidproject.data.mapper.wallpapers

import com.example.androidproject.data.mapper.wallpaper_details.toDomain
import com.example.androidproject.data.model.WallpaperResponseDto
import com.example.androidproject.domain.model.GetWallpaperResponse

fun WallpaperResponseDto.toDomain(): GetWallpaperResponse {
    return GetWallpaperResponse(
        hits = hits.map { it.toDomain() }
    )
}