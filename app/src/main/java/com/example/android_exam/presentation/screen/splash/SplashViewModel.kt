package com.example.android_exam.presentation.screen.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android_exam.presentation.event.SplashEvent
import com.example.android_exam.domain.usecase.splash.GetUserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(private val getUserUseCase: GetUserUseCase) :
    ViewModel() {

    private val _uiEvent = MutableSharedFlow<SplashUiEvent>(1)
    val uiEvent: SharedFlow<SplashUiEvent> get() = _uiEvent

    fun onEvent(event: SplashEvent) {
        when (event) {
            is SplashEvent.ReadSessionEvent -> readSession()
        }
    }

    private fun readSession() {
        viewModelScope.launch {
            delay(500)
            _uiEvent.emit(
                if (getUserUseCase() == null) {
                    SplashUiEvent.NavigateToSignIn
                } else {
                    SplashUiEvent.NavigateToWallpapers
                }
            )
        }
    }

    sealed class SplashUiEvent {
        data object NavigateToSignIn : SplashUiEvent()
        data object NavigateToWallpapers : SplashUiEvent()
    }
}