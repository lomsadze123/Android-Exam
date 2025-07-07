package com.example.androidproject.domain.usecase.sign_up

import com.example.androidproject.data.common.Resource
import com.example.androidproject.domain.repository.AuthRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SignUpWithEmailAndPasswordUseCase @Inject constructor(private val authRepository: AuthRepository) {
    suspend operator fun invoke(email: String, password: String): Flow<Resource<Unit>> =
        authRepository.firebaseSignUpWithEmailAndPassword(email, password)
}