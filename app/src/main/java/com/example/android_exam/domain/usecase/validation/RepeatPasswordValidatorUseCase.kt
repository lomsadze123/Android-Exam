package com.example.android_exam.domain.usecase.validation

class RepeatPasswordValidatorUseCase {
    operator fun invoke(password: String, repeatPassword: String): Boolean =
        password.isNotBlank() && repeatPassword == password
}