package com.example.android_exam.domain.usecase.profile

import com.example.android_exam.domain.repository.AuthRepository
import javax.inject.Inject

class SetUserImageUseCase @Inject constructor(private val authRepository: AuthRepository) {
    suspend operator fun invoke(url: String) = authRepository.setUserImage(url)
}