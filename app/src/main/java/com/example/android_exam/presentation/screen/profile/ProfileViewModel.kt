package com.example.android_exam.presentation.screen.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android_exam.presentation.event.ProfileEvent
import com.example.android_exam.domain.usecase.profile.GetUserUseCase
import com.example.android_exam.domain.usecase.profile.SignOutUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(getUserUseCase: GetUserUseCase, private val signOutUseCase: SignOutUseCase): ViewModel() {
    private val _userStateFlow = MutableStateFlow(getUserUseCase())
    val userStateFlow = _userStateFlow.asStateFlow()

    private val _uiEvent = MutableSharedFlow<ProfileUiEvent>()
    val uiEvent = _uiEvent.asSharedFlow()

    fun onEvent(event: ProfileEvent) {
        when(event) {
            is ProfileEvent.SignOutEvent -> signOut()
        }
    }

    private fun signOut() {
        signOutUseCase()
        viewModelScope.launch {
            _uiEvent.emit(ProfileUiEvent.GoToSignInFragmentEvent)
        }
    }

    sealed interface ProfileUiEvent {
        data object GoToSignInFragmentEvent : ProfileUiEvent
    }
}