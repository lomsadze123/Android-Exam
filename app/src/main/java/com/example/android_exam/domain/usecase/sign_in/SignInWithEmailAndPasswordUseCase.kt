package com.example.androidproject.domain.usecase.sign_in

import com.example.androidproject.data.common.Resource
import com.example.androidproject.domain.repository.AuthRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SignInWithEmailAndPasswordUseCase @Inject constructor(private val authRepository: AuthRepository) {
    suspend operator fun invoke(email: String, password: String): Flow<Resource<Unit>> =
        authRepository.firebaseSignInWithEmailAndPassword(email, password)
}