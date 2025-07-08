package com.example.android_exam.presentation.event

sealed interface SplashEvent {
    data object ReadSessionEvent : SplashEvent
}