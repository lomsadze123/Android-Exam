package com.example.android_exam.presentation.event

sealed interface ProfileEvent {
    data object SignOutEvent : ProfileEvent
}