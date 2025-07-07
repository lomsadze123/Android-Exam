package com.example.androidproject.data.repository

import com.example.androidproject.presentation.model.category.Categories
import com.example.androidproject.presentation.model.category.Category
import com.example.androidproject.domain.repository.CategoryRepository
import javax.inject.Inject

class CategoryRepositoryImpl @Inject constructor() : CategoryRepository {
    override suspend fun getCategories(): List<Category> {
        return Categories.entries.map { category ->
            Category(categories = category)
        }
    }
}