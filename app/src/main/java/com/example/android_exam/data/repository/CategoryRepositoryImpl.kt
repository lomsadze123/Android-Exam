package com.example.android_exam.data.repository

import com.example.android_exam.presentation.model.category.Categories
import com.example.android_exam.presentation.model.category.Category
import com.example.android_exam.domain.repository.CategoryRepository
import javax.inject.Inject

class CategoryRepositoryImpl @Inject constructor() : CategoryRepository {
    override suspend fun getCategories(): List<Category> {
        return Categories.entries.map { category ->
            Category(categories = category)
        }
    }
}