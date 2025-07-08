package com.example.android_exam.data.mapper.wallpaper_details

import com.example.android_exam.data.model.ImageDto
import com.example.android_exam.domain.model.GetImage

fun ImageDto.toDomain(): GetImage {
    return GetImage(
        id, pageURL, tags, previewURL, webformatURL, largeImageURL, views, downloads, collections, likes, comments
    )
}