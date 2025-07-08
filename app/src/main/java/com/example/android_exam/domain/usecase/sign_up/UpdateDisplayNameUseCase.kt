package com.example.android_exam.domain.usecase.sign_up

import com.example.android_exam.data.common.Resource
import com.example.android_exam.domain.repository.AuthRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class UpdateDisplayNameUseCase @Inject constructor(private val authRepository: AuthRepository) {
    suspend operator fun invoke(fullName: String): Flow<Resource<Unit>> {
        return authRepository.updateDisplayName(fullName)
    }
}