package com.example.android_exam.presentation.screen.sign_in

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android_exam.presentation.event.SignInEvent
import com.example.android_exam.presentation.state.sign_in.SignInState
import com.example.android_exam.data.common.Resource
import com.example.android_exam.domain.usecase.sign_in.SignInWithEmailAndPasswordUseCase
import com.example.android_exam.domain.usecase.validation.EmailValidatorUseCase
import com.example.android_exam.domain.usecase.validation.PasswordValidatorUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(
    private val signIn: SignInWithEmailAndPasswordUseCase,
    private val emailValidator: EmailValidatorUseCase,
    private val passwordValidator: PasswordValidatorUseCase
) : ViewModel() {

    private val _signInStateFlow = MutableStateFlow(SignInState())
    val signInStateFlow get() = _signInStateFlow.asStateFlow()

    private val _uiEvent = MutableSharedFlow<SignInUiEvent>()
    val uiEvent = _uiEvent.asSharedFlow()

    fun onEvent(event: SignInEvent){
        when(event) {
            is SignInEvent.SignIn-> validateForm(email = event.email, password = event.password)
        }
    }

    private fun signInWithEmailAndPassword(email: String, password: String) =
        viewModelScope.launch {
            signIn(email, password).collect { resource ->
                when (resource) {
                    is Resource.Loading -> _signInStateFlow.update { currentState->currentState.copy(isLoading = resource.loading)}

                    is Resource.Success -> {
                        _signInStateFlow.update {currentState-> currentState.copy(data = resource.response)}
                        _uiEvent.emit(SignInUiEvent.NavigateToWallpapers)
                    }

                    is Resource.Error -> _signInStateFlow.update { currentState->currentState.copy(errorMessage = resource.errorMessage)}
                }
            }
        }

    private fun validateForm(email: String, password: String) {
       if (!emailValidator(email)) {
           _signInStateFlow.update { it.copy(errorMessage = "Email is not valid!") }
       }else if(!passwordValidator(password)) {
           _signInStateFlow.update { it.copy(errorMessage = "Password is not valid!") }
       } else{
           signInWithEmailAndPassword(email = email, password = password)
       }
    }

    sealed interface SignInUiEvent {
        data object NavigateToWallpapers : SignInUiEvent
    }
}