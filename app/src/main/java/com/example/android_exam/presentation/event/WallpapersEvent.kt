package com.example.android_exam.presentation.event

sealed interface WallpapersEvent {
    data class FilterByCategoryEvent(val category: String) : WallpapersEvent
    data class FilterByQueryEvent(val query: String) : WallpapersEvent
    data object FetchDefaultDataEvent : WallpapersEvent
}