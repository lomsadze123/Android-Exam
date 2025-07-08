package com.example.android_exam.domain.usecase.validation

class FullNameValidationUseCase {
    operator fun invoke(fullName: String): Boolean {
        return fullName.isNotBlank()
    }
}