package com.example.android_exam.domain.usecase.profile

import com.example.android_exam.domain.repository.AuthRepository
import javax.inject.Inject

class SignOutUseCase @Inject constructor(private val authRepository: AuthRepository){
    operator fun invoke() {
        return authRepository.signOut()
    }
}