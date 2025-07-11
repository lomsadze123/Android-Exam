package com.example.android_exam.domain.usecase.validation

class EmailValidatorUseCase{

    private val emailRegex = Regex(
        "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
                "\\@" + "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                "(" + "\\." + "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" + ")+"
    )

    operator fun invoke(email: String): Boolean {
        return email.isNotBlank() && email.matches(emailRegex)
    }
}