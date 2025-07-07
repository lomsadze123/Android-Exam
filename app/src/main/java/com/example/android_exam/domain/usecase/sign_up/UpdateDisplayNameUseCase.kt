package com.example.androidproject.domain.usecase.sign_up

import com.example.androidproject.data.common.Resource
import com.example.androidproject.domain.repository.AuthRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class UpdateDisplayNameUseCase @Inject constructor(private val authRepository: AuthRepository) {
    suspend operator fun invoke(fullName: String): Flow<Resource<Unit>> {
        return authRepository.updateDisplayName(fullName)
    }
}