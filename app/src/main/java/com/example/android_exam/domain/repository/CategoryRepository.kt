package com.example.androidproject.domain.repository

import com.example.androidproject.presentation.model.category.Category

interface CategoryRepository {
    suspend fun getCategories(): List<Category>
}