package com.example.androidproject.data.mapper.wallpaper_details

import com.example.androidproject.data.model.ImageDto
import com.example.androidproject.domain.model.GetImage

fun ImageDto.toDomain(): GetImage {
    return GetImage(
        id, pageURL, tags, previewURL, webformatURL, largeImageURL, views, downloads, collections, likes, comments
    )
}