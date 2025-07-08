package com.example.android_exam.domain.usecase.profile

import com.example.android_exam.domain.repository.AuthRepository
import com.google.firebase.auth.FirebaseUser
import javax.inject.Inject

class GetUserUseCase @Inject constructor(private val authRepository: AuthRepository) {
    operator fun invoke(): FirebaseUser? {
        return authRepository.getUser()
    }
}