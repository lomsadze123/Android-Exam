package com.example.androidproject.domain.usecase.profile

import com.example.androidproject.domain.repository.AuthRepository
import javax.inject.Inject

class SignOutUseCase @Inject constructor(private val authRepository: AuthRepository){
    operator fun invoke() {
        return authRepository.signOut()
    }
}