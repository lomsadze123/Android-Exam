package com.example.androidproject.di

import com.example.androidproject.domain.usecase.validation.EmailValidatorUseCase
import com.example.androidproject.domain.usecase.validation.PasswordValidatorUseCase
import com.example.androidproject.domain.repository.AuthRepository
import com.example.androidproject.domain.repository.SingleImageRepository
import com.example.androidproject.domain.repository.WallpaperRepository
import com.example.androidproject.domain.usecase.sign_in.SignInWithEmailAndPasswordUseCase
import com.example.androidproject.domain.usecase.sign_up.SignUpWithEmailAndPasswordUseCase
import com.example.androidproject.domain.usecase.validation.FullNameValidationUseCase
import com.example.androidproject.domain.usecase.validation.RepeatPasswordValidatorUseCase
import com.example.androidproject.domain.usecase.wallpaper_details.GetWallpaperDetailsUseCase
import com.example.androidproject.domain.usecase.wallpapers.GetWallpapersByFilterUseCase
import com.example.androidproject.domain.usecase.wallpapers.GetWallpapersUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Singleton
    @Provides
    fun provideFullNameValidationUseCase(): FullNameValidationUseCase {
        return FullNameValidationUseCase()
    }

    @Singleton
    @Provides
    fun provideEmailValidatorUseCase(): EmailValidatorUseCase {
        return EmailValidatorUseCase()
    }

    @Singleton
    @Provides
    fun providePasswordValidatorUseCase(): PasswordValidatorUseCase {
        return PasswordValidatorUseCase()
    }

    @Singleton
    @Provides
    fun provideRepeatPasswordValidatorUseCase(): RepeatPasswordValidatorUseCase {
        return RepeatPasswordValidatorUseCase()
    }

    @Singleton
    @Provides
    fun provideSignInUseCase(authRepository: AuthRepository): SignInWithEmailAndPasswordUseCase {
        return SignInWithEmailAndPasswordUseCase(authRepository)
    }

    @Singleton
    @Provides
    fun provideSignUpUseCase(authRepository: AuthRepository): SignUpWithEmailAndPasswordUseCase {
        return SignUpWithEmailAndPasswordUseCase(authRepository)
    }

    @Singleton
    @Provides
    fun provideWallpapersUseCase(wallpaperRepository: WallpaperRepository): GetWallpapersUseCase {
        return GetWallpapersUseCase(wallpaperRepository)
    }

    @Singleton
    @Provides
    fun provideWallpapersByFilterUseCase(wallpaperRepository: WallpaperRepository): GetWallpapersByFilterUseCase {
        return GetWallpapersByFilterUseCase(wallpaperRepository)
    }

    @Singleton
    @Provides
    fun provideWallpaperDetailsUseCase(singleImageRepository: SingleImageRepository): GetWallpaperDetailsUseCase {
        return GetWallpaperDetailsUseCase(singleImageRepository)
    }
}