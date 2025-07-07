package com.example.androidproject.domain.usecase.profile

import com.example.androidproject.domain.repository.AuthRepository
import javax.inject.Inject

class SetUserImageUseCase @Inject constructor(private val authRepository: AuthRepository) {
    suspend operator fun invoke(url: String) = authRepository.setUserImage(url)
}