package com.example.android_exam.presentation.mapper

import com.example.android_exam.presentation.model.Image
import com.example.androidproject.domain.model.GetImage

fun GetImage.toPresenter(): Image = Image(
    id,
    pageURL,
    tags,
    previewURL,
    webformatURL,
    largeImageURL,
    views,
    downloads,
    collections,
    likes,
    comments
)