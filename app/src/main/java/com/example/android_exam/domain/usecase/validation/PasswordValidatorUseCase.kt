package com.example.android_exam.domain.usecase.validation

class PasswordValidatorUseCase {
    operator fun invoke(password: String): Boolean =
        password.isNotBlank() && password.trim().length >= 8
}