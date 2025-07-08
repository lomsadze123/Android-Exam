package com.example.android_exam.domain.usecase.sign_up

import com.example.android_exam.data.common.Resource
import com.example.android_exam.domain.repository.AuthRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SignUpWithEmailAndPasswordUseCase @Inject constructor(private val authRepository: AuthRepository) {
    suspend operator fun invoke(email: String, password: String): Flow<Resource<Unit>> =
        authRepository.firebaseSignUpWithEmailAndPassword(email, password)
}