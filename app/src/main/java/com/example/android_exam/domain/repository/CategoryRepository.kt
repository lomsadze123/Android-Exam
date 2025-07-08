package com.example.android_exam.domain.repository

import com.example.android_exam.presentation.model.category.Category

interface CategoryRepository {
    suspend fun getCategories(): List<Category>
}